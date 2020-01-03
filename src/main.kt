import java.util.Scanner

fun main(args: Array<String>) {

    val scanner = Scanner(System.`in`)

    var choice = ""

    var actualWater = 400
    var actualMilk = 540
    var actualBeans = 120
    var actualCups = 9
    var actualMoney = 550


    fun checkIfCanMakeCoffee(water: Int, milk: Int, beans: Int): Boolean {
        val nbreWater = actualWater / water
        val nbreMilk = actualMilk / milk
        val nbreBeans = actualBeans / beans

        var isEnough = false

        if (nbreWater < 1 && (nbreMilk >= 1 && nbreBeans >= 1)) {
            println("Sorry, not enough water!")
        } else if (nbreMilk < 1 && (nbreWater >= 1 && nbreBeans >= 1)) {
            println("Sorry, not enough Milk!")
        } else if (nbreBeans < 1 && (nbreWater >= 1 && nbreMilk >= 1)) {
            println("Sorry, not enough Beans!")
        } else if (nbreBeans < 1 && nbreMilk < 1 && nbreBeans < 1) {
            println("Sorry, not enough resources!")
        } else {
            println("I have enough resources, making you a coffee!")
            isEnough = true
        }

        return isEnough
    }

    fun buyExpressoCoffee() {
        if (checkIfCanMakeCoffee(250, 1, 16)) {
            actualWater -= 250
            actualBeans -= 16
            actualMoney += 4
            actualCups -= 1
        }

    }

    fun buyLatteCoffee() {
        if (checkIfCanMakeCoffee(370, 75, 20)) {
            actualWater -= 350
            actualMilk -= 75
            actualBeans -= 20
            actualCups -= 1
            actualMoney += 7
        }

    }

    fun buyCappuccinoCoffee() {
        checkIfCanMakeCoffee(200, 100, 12)
        actualWater -= 200
        actualMilk -= 100
        actualBeans -= 12
        actualCups -= 1
        actualMoney += 6
    }

    fun fillCoffeeMachine(waterToAdd: Int, milkToAdd: Int, beansToAdd: Int, cupsToAdd: Int) {
        actualWater += waterToAdd
        actualMilk += milkToAdd
        actualBeans += beansToAdd
        actualCups += cupsToAdd
    }

    fun buy() {
        print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
        when (scanner.nextLine()) {
            1.toString() -> buyExpressoCoffee()
            2.toString() -> buyLatteCoffee()
            3.toString() -> buyCappuccinoCoffee()
            "back" -> choice == ""
        }
        println()
    }

    fun fill() {
        print("Write how many ml of water do you want to add: ")
        val waterToAdd = scanner.nextInt()
        print("Write how many ml of milk do you want to add: ")
        val milkToAdd = scanner.nextInt()
        print("Write how many grams of coffee beans do you want to add: ")
        val beansToAdd = scanner.nextInt()
        print("Write how many disposable cups of coffee do you want to add: ")
        val cupsToAdd = scanner.nextInt()
        fillCoffeeMachine(waterToAdd, milkToAdd, beansToAdd, cupsToAdd)
        println()
    }

    fun take() {
        println("I give you $$actualMoney")
        actualMoney -= actualMoney
        println()
    }

    fun remaining() {
        println("The coffee machine has:")
        println("$actualWater of water")
        println("$actualMilk of milk")
        println("$actualBeans of coffee beans")
        println("$actualCups of disposable cups")
        println("$actualMoney of money")
        println()
    }

    var isContinue: Boolean = true

    while (isContinue) {
        print("Write action (buy, fill, take, remaining, exit): ")
        choice = scanner.nextLine()
        when (choice) {
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
            "remaining" -> remaining()
            "exit" -> {
                isContinue = false
            }
            else -> {
                println("Unknown command")
            }
        }
    }
}

