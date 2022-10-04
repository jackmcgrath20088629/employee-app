package ie.setu

import kotlin.math.round

var employee =  Employee("Malcolm", "White", 'm', 7777, 20189.21, 38.5, 3.7, 17800.50, 87.33)

fun main(args: Array<String>){

    fun add(){
        print("Enter first name: ")
        val firstName = readLine().toString()
        print("Enter surname: ")
        val surname = readLine().toString()
        print("Enter gender (m/f): ")
        val gender = readLine()!!.toCharArray()[0]
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
         |Employee Menu
         |1. Add Employee
         |2. List All Employees
         |3. Search Employees 
         |4. Print Payslip for Employee
         |-1. Exit
         |       
         |Enter Option : """.trimMargin())
    return readLine()!!.toInt()
}

fun roundTwoDecimals(number: Double) = round(number * 100) / 100
//fun roundTwoDecimals(number: Double) = "%.2f".format(number).toDouble()



