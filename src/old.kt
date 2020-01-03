import java.util.*


fun main(args: Array<String>){
    val scanner = Scanner(System.`in`)

    println("Write how many ml of water the coffee machine has: ")
    val x = scanner.nextInt()

    println("Write how many ml of milk the coffee machine has: ")
    val y = scanner.nextInt()

    println("Write how many grams of coffee beans the coffee machine has: ")
    val z = scanner.nextInt()

    println("Write how many cups of coffee you will need: ")
    val numCups = scanner.nextInt()

    val a = x / 200
    val b = y / 50
    val c = z / 15

    println(a)
    println(b)
    println(c)

    if (a == 0 || b == 0 || c == 0){
        if(numCups == 0){
            println("Yes, I can make that amount of coffee")
        } else {
            println("No, I can make only 0 cups of coffee")
        }
    } else  {

        if ((a == b && a < c) || (a < b && (a < c || a == c || b == c))){
            if (a > numCups){
                println("Yes, I can make that amount of coffee (and even ${a - numCups} more than that)")
            } else if(a < numCups){
                println("No, I can make only $a cups of coffee")
            } else if (a == numCups){
                println("Yes, I can make that amount of coffee")
            }
        } else if((b == c && b < a) || (b < c && (b < a || b == c || c == a))){
            if (b < c){
                if (b > numCups){
                    println("Yes, I can make that amount of coffee (and even ${b - numCups} more than that)")
                } else if(b < numCups){
                    println("No, I can make only $b cups of coffee")
                } else if (b == numCups){

                    println("Yes, I can make that amount of coffee")
                }
            }
        }  else if((a == c && a < b) || (c < a && (c < b || a == b || c == b))){

            if (c > numCups) {
                println("Yes, I can make that amount of coffee (and even ${c - numCups} more than that)")
            } else if (c < numCups) {
                println("No, I can make only $c cups of coffee")
            } else if (c == numCups) {
                println("Yes, I can make that amount of coffee")
            }


        } else if(a == b  && b == c){
            if(a > numCups){
                println("Yes, I can make that amount of coffee (and even ${c - numCups} more than that)")
            } else if (c < numCups){
                println("No, I can make only $c cups of coffee")
            } else if (c == numCups){
                println("Yes, I can make that amount of coffee")
            }
        }
    }
}