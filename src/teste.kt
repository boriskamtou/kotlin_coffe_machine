import java.util.Scanner



fun main() {

    val scanner = Scanner(System.`in`)
    fun remaining(water: Int, milk: Int, beans: Int, cup: Int, money: Int){
        println("$water of water")
        println("$milk of water")
        println("$beans of water")
        println("$cup of water")
        println("$$money of water")
        println()
    }

    fun isEnough(type: String, water: Int, milk: Int, beans: Int, cups: Int): Boolean{
        var enough: Boolean = false

        var waterLimit: Int = 0
        var milkLimit: Int = 0
        var beansLimit: Int = 0

        when(type){
            "1" -> {
                waterLimit = 250
                milkLimit = 0
                beansLimit = 16
            }
            "2" -> {
                waterLimit = 350
                milkLimit = 75
                beansLimit = 20
            }
            "3" -> {
                waterLimit = 200
                milkLimit = 100
                beansLimit = 12
            }
            else -> println("We have not this coffee")
        }

        if (water < waterLimit){
            println("Sorry, not enough water!")
        } else if(milk < milkLimit){
            println("Sorry, not enough milk!")
        } else if(beans < beansLimit){
            println("Sorry, not enough beans!")
        } else if(cups < 1){
            println("Sorry, not enough disposable cup!")
        } else {
            enough = true
            println("I have enough resources, making you a coffee!")
        }
        return enough
    }

    var water = 400
    var milk = 540
    var beans = 120
    var cups = 9
    var money = 550

    var isTrue: Boolean = true

    while (isTrue){
        println("Write action (buy, fill, take, remaining, exit): ")
        var choice: String = scanner.nextLine()
        println()
        when(choice){
            "buy" -> {
                print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, " +
                        "back - to main menu: ")
                var type: String = scanner.nextLine()
                var enough: Boolean = isEnough(type, water, milk, beans, cups)
                when(type){
                    "1" -> {
                        if (enough){
                            water -= 250
                            beans -= 16
                            cups -= 1
                            money += 4
                        }
                    }
                    "2" -> {
                        if (enough){
                            water -= 350
                            milk -= 75
                            beans -= 20
                            cups -= 1
                            money += 7
                        }
                    }
                    "3" -> {
                        if (enough){
                            water -= 200
                            milk -= 100
                            beans -= 12
                            cups -= 1
                            money += 6
                        }
                    }
                    else -> println("Unknown coffee type")
                }
            }
            "fill" -> {
                println("Write how many ml of water do you want to add: ")
                water += scanner.nextInt()
                println("Write how many ml of milk do you want to add: ")
                milk += scanner.nextInt()
                println("Write how many grams of coffee beans do you want to add: ")
                beans += scanner.nextInt()
                println("Write how many disposable cups of coffee do you want to add: ")
                cups += scanner.nextInt()
            }
            "take" -> {
                println("I gave you $money")
                money = 0
            }
            "remaining" -> {
                remaining(water, milk, beans, cups, money)
            }
            "exit" -> {
                isTrue = false
            }
            else -> println("Unknown command");
        }
    }

}

