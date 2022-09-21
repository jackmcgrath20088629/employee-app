fun main(args: Array<String>) {
    println("Pay Slip Printer")
    printPayslip()
    println("\n")
    printPayslipsWithRounding()

}

fun printPayslip(){

    println ("___________________________________________________________")
    println ("|   Monthly Payslip                                       |")
    println ("|_________________________________________________________|")
    println ("|                                                         |")
    println ("|   Employee Name:  ${firstName.uppercase()} ${surname.uppercase()} (${gender.uppercase()}) Employee ID: $employeeID   |")
    println ("|                                                         |")
    println ("|_________________________________________________________|")
    println ("|                                                         |")
    println ("|   Payment Details \t\t\t\t Deduction Detail  \t\t\t\t  |")
    println ("|_________________________________________________________|")
    println ("|   Salary: $monthlySalary \t\t\t\t PAYE: $monthlyPaye \t\t\t\t\t\t|")
    println ("|   Bonus:  ${roundTwoDecimals(annualBonus/12)} \t\t\t\t PRSI: $monthlyPrsi  \t\t\t\t\t\t|")
    println ("|    \t\t\t\t\t\t\t\t Cycle To Work: $cycleToWorkMonthlyDeduction \t\t\t\t|")
    println ("|_________________________________________________________|")
    println ("|   Gross: $grossPay \t\t\t\tTotal Deductions: $totalDeductions \t\t\t|")
    println ("|_________________________________________________________|")
    println ("|   \t\t\t\t\t\t Net pay: ${roundTwoDecimals(grossPay - totalDeductions)}  \t\t\t\t\t\t\t|")
    println ("|_________________________________________________________|")

    val monthlySalary = (grossSalary/12)
    val monthlyPrsi = monthlySalary * (prsiPercentage / 100)
    val monthlyPaye = monthlySalary * (payePercentage / 100)
    val grossPay = (monthlySalary + (annualBonus/12))
    val totalDeductions = (monthlyPrsi + monthlyPrsi + cycleToWorkMonthlyDeduction)

}

/*fun printPayslipsWithRounding(){
    println ("___________________________________________________________")
    println ("|   Monthly Payslip                                       |")
    println ("|_________________________________________________________|")
    println ("|                                                         |")
    println ("|   Employee Name:  " + firstName.uppercase() + " " + surname.uppercase() + "(" + gender.uppercase() + ")   Employee ID: " + employeeID + "    |")
    println ("|                                                         |")
    println ("|_________________________________________________________|")
    println ("|                                                         |")
    println ("|   Payment Details \t\t\t\t Deduction Detail  \t\t\t\t  |")
    println ("|_________________________________________________________|")
    println ("|   Salary: " + "%.2f".format(monthlySalary) + "\t\t PAYE: " + "%.2f".format(monthlyPaye) + "\t\t\t|")
    println ("|   Bonus:  " + "%.2f".format((annualBonus / 12)) + "\t\t\t\t PRSI: " + "%.2f".format(monthlyPrsi)  + "\t\t\t|")
    println ("|    \t\t\t\t\t\t\t\t Cycle To Work: " + cycleToWorkMonthlyDeduction  + "\t\t\t\t|")
    println ("|_________________________________________________________|")
    println ("|   Gross:  " + "%.2f".format(grossPay) + " \t\tTotal Deductions: " + "%.2f".format(totalDeductions) + " |")
    println ("|_________________________________________________________|")
    println ("|   \t\t\t\t Net Pay:" + "%.2f".format((grossPay - totalDeductions)) + " \t\t\t\t\t\t\t|")
    println ("|_________________________________________________________|")

    val monthlySalary = (grossSalary/12)
    val monthlyPrsi = monthlySalary * (prsiPercentage / 100)
    val monthlyPaye = monthlySalary * (payePercentage / 100)
    val grossPay = (monthlySalary + (annualBonus/12))
    val totalDeductions = (monthlyPrsi + monthlyPrsi + cycleToWorkMonthlyDeduction)

}
*/

val firstName = "Joe"
val surname = "Soap"
val gender = 'm'
val employeeID = 6143
val grossSalary = 67543.21
val payePercentage = 38.5
val prsiPercentage = 5.2
val annualBonus = 1450.50
val cycleToWorkMonthlyDeduction = 54.33