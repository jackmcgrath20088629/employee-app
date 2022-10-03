package ie.setu

import kotlin.math.round

var employee =  Employee("Malcolm", "White", 'm', 7777, 20189.21, 38.5, 3.7, 17800.50, 87.33)

fun main(args: Array<String>){

    fun add()){
        print("Enter first name: ")
        val firstName = readLine().toString()
        print("Enter surname: ")
        val surname = readLine().toString()
        print("Enter gender (m/f): ")
        val gender = readLine()!!.toCharArray()[0]
        print("Enter employee ID: ")
        val employeeID = readLine()!!.toInt()
        print("Enter gross salary: ")
        val grossSalary = readLine()!!.toDouble()
        print("Enter PAYE %: ")
        val payePercentage = readLine()!!.toDouble()
        print("Enter PRSI %: ")
        val prsiPercentage = readLine()!!.toDouble()
        print("Enter Annual Bonus: ")
        val annualBonus= readLine()!!.toDouble()
        print("Enter Cycle to Work Deduction: ")
        val cycleToWorkMonthlyDeduction= readLine()!!.toDouble()

        employee = Employee(firstName, surname, gender, employeeID, grossSalary, payePercentage, prsiPercentage, annualBonus, cycleToWorkMonthlyDeduction)
    }

    var input : Int

    do {1
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
         ¦ Employee Menu for ${getFullName()}
         ¦ 1. Monthly Salary
         ¦ 2. Monthly PRSI
         ¦ 3. Monthly PAYE
         ¦ 4. Monthly Gross Pay
         ¦ 5. Monthly Total Deductions
         ¦ 6. Monthly Net Pay
         ¦ 7. Full Payslip
         ¦-1. Exit
         ¦ Enter Option : """)
    return readLine()!!.toInt()
}

fun getFullName() = when (employee.gender){
    'm', 'M' -> "Mr. ${employee.firstName} ${employee.surname}"
    'f', 'F' -> "Ms.  ${employee.firstName} ${employee.surname}"
    else ->  "${employee.firstName} ${employee.surname}"
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



