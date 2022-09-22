package ie.setu

import kotlin.math.round

val firstName = "Joe"
val surname = "Soap"
val gender = 'm'
val employeeID = 6143
val grossSalary = 67543.21
val payePercentage = 38.5
val prsiPercentage = 5.2
val annualBonus = 1450.50
val cycleToWorkMonthlyDeduction = 54.33

fun main(args: Array<String>){

    var input : Int

    do {
        input = menu()
        when(input) {
            1 -> println("Monthly Salary: ${getMonthlySalary()}")
            2 -> println("Monthly PRSI: ${getMonthlyPRSI()}")
            3 ->println("Monthly PAYE: ${getMonthlyPAYE()}")
            4 -> println("Monthly Gross Pay: ${getGrossMonthlyPay()}")
            5 -> println("Monthly Total Deductions: ${getTotalMonthlyDeductions()}")
            6 -> println("Monthly Net Pay: ${getNetMonthlyPay()}")
            7 -> println(getPayslip())
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
}
fun menu() : Int {
    print("""
         Employee Menu for ${getFullName()}
           1. Monthly Salary
           2. Monthly PRSI
           3. Monthly PAYE
           4. Monthly Gross Pay
           5. Monthly Total Deductions
           6. Monthly Net Pay
           7. Full Payslip
          -1. Exit
         Enter Option : """)
    return readLine()!!.toInt()
}

fun getFullName() = when (gender){

    'm', 'M' -> "Mr. $firstName $surname"

    'f', 'F' -> "Ms. $firstName $surname"

    else -> "$firstName $surname"
}

fun getMonthlySalary() = roundTwoDecimals(grossSalary / 12)
fun getMonthlyPRSI() = roundTwoDecimals(getMonthlySalary() * (prsiPercentage / 100))
fun getMonthlyPAYE() = roundTwoDecimals(getMonthlySalary() * (payePercentage / 100))
fun getGrossMonthlyPay() = roundTwoDecimals(getMonthlySalary() + (annualBonus / 12))
fun getTotalMonthlyDeductions() = roundTwoDecimals((getMonthlyPRSI() + getMonthlyPAYE() + cycleToWorkMonthlyDeduction))
fun getNetMonthlyPay() = roundTwoDecimals(roundTwoDecimals(getGrossMonthlyPay() - getTotalMonthlyDeductions()))

fun getPayslip() {

    val monthlySalary = roundTwoDecimals(grossSalary / 12)
    val monthlyPrsi = roundTwoDecimals(monthlySalary * (prsiPercentage / 100))
    val monthlyPaye = roundTwoDecimals(monthlySalary * (payePercentage / 100))
    val grossPay = roundTwoDecimals(monthlySalary + (annualBonus / 12))
    val totalDeductions = roundTwoDecimals((monthlyPrsi + monthlyPrsi + cycleToWorkMonthlyDeduction))

    println(
        """
        ______________________________________________________________________
         Monthly Payslip:             ${firstName.uppercase()} ${surname.uppercase()} (${gender.uppercase()}), ID: $employeeID                  
        ______________________________________________________________________    
         Pay Details (gross pay: $grossPay)                                                                    
        ______________________________________________________________________
         Salary: $monthlySalary
         Bonus:  ${roundTwoDecimals(annualBonus / 12)}            
        ______________________________________________________________________
         Deduction Details (total Deductions: $totalDeductions)      
        ______________________________________________________________________
         PAYE: $monthlyPaye                
         PRSI: $monthlyPrsi  
         Cycle To Work: $cycleToWorkMonthlyDeduction         
        ______________________________________________________________________
         Net pay: ${roundTwoDecimals(grossPay - totalDeductions)} 
        ______________________________________________________________________"""
    )
}

fun roundTwoDecimals(number: Double) = round(number * 100) / 100
//fun roundTwoDecimals(number: Double) = "%.2f".format(number).toDouble()



