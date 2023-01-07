import kotlin.system.exitProcess

interface BankAccount{
    var currentBalance : Int
    fun checkBalance(): Int
    fun withdraw(amount: Int)
    fun deposit(amount: Int)
}
class DebitAccount: BankAccount{
    override var currentBalance: Int = 0
    override fun checkBalance(): Int {
        return currentBalance
    }

    override fun deposit(amount: Int) {
        currentBalance+=amount
        print("Ammount succesfully deposited. Current Amount is $currentBalance")
    }

    override fun withdraw(amount: Int) {
        if ((currentBalance - amount) < 0){
            print("Amount exceeds Current Balance. Withdrawal failed..")
        }
        else{
            currentBalance-=amount
            print("Amount withdrawn succesfully. Current balance is $currentBalance")
    }
}}
class CreditAccount:BankAccount{
    override var currentBalance: Int = 0
    override fun checkBalance(): Int {
        return currentBalance
    }

    override fun deposit(amount: Int) {
        if ((amount + currentBalance) < 0){
            print("Amount not enough to be paid off. Operation failed..")
        }
        else{
            currentBalance+=amount
            print("Your current balance is $currentBalance")
        }
    }

    override fun withdraw(amount: Int) {
        currentBalance-=amount
        print("Your current balance is $currentBalance")
    }
}
class CheckingAccount : BankAccount{
    override var currentBalance: Int = 0
    override fun checkBalance():Int {
        return currentBalance
    }

    override fun deposit(amount: Int) {
        currentBalance+=amount
        print("Amount successfully deposited. Current balance is $currentBalance")
    }

    override fun withdraw(amount: Int) {
        currentBalance-=amount
        print("Amount successfully withdrawn. Current balance is $currentBalance")
    }
}
println("Welcome to your Banking System")
println("What type of account would you like to create?")
println("1. Debit Account\n2. Credit Account\n3. Checking Account\nChoose an option (1,2,3)")
var userChoice : Int = 0
var accountType: BankAccount? = null
do{
    try {
        userChoice = readLine()!!.toInt()
        accountType = when (userChoice){
            1->DebitAccount()
            2->CreditAccount()
            3->CheckingAccount()
            else->{
                println("Please choose from the given options")
                continue
            }
        }
    }catch (e: Throwable){
        println("Please enter a valid value..")
        continue
    }
} while (userChoice!=1 && userChoice!=2 && userChoice!=3)
println("What operation do you want to perform?")
println("1. Deposit Amount\n2. Withdraw Amount\n3. Check Balance\n4. Exit\nChoose option (1,2,3,4)")
var userOperation : Int = 0
var amount: Int = 0
do {
    try {
        userOperation = readLine()!!.toInt()
        if (userOperation == 1){
            println("Enter the amount to be deposited")
            while (true){
            try {
                amount = readLine()!!.toInt()
                accountType!!.deposit(amount)
                break
            }catch (e: Throwable){
                println("Please enter an appropriate value")
            }

        }
    } else if (userOperation == 2){
        println("Enter the amount to be withdrawn")
        while (true){
            try {
                amount = readLine()!!.toInt()
                accountType!!.withdraw(amount)
                break
            }catch (e: Throwable){
                println("Please enter an appropriate value")
            }
        }
     } else if (userOperation == 3){
         print( accountType!!.checkBalance())
         break
        }
        else{
            print("Terminating...")
            exitProcess(0)}
}catch (t: Throwable) {print("Please enter a valid value")}}while (userOperation!=1 && userOperation!=2 && userOperation!=3 && userOperation!=4)