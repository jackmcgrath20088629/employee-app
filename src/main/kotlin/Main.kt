import kotlin.math.round
fun main(args: Array<String>) {
    println("Pay Slip Printer")
    printPayslip()
    println("\n")
    printPayslipsWithRounding()

}


fun printPayslip(){
    println(
        """
         Monthly payslip
        ______________________________________________________________________
         Employee name: ${firstName.uppercase()} ${surname.uppercase()} (${gender.uppercase()}), Employee ID: $employeeID                  
        ______________________________________________________________________    
         Salary: $monthlySalary
         Bonus:  ${roundTwoDecimals(annualBonus / 12)}             
        ______________________________________________________________________
         PAYE: $monthlyPaye                
         PRSI: $monthlyPrsi  
         Cycle To Work: $cycleToWorkMonthlyDeduction                                                         
        ______________________________________________________________________
        Payment (gross pay: $grossPay)                                                                    
        ______________________________________________________________________
        Deductions (total Deductions: $totalDeductions)  
        ______________________________________________________________________
             Net pay: ${roundTwoDecimals(grossPay - totalDeductions)} 
        ______________________________________________________________________"""
    )





    val monthlySalary = (grossSalary/12)
    val monthlyPrsi = monthlySalary * (prsiPercentage / 100)
    val monthlyPaye = monthlySalary * (payePercentage / 100)
    val grossPay = (monthlySalary + (annualBonus/12))
    val totalDeductions = (monthlyPrsi + monthlyPrsi + cycleToWorkMonthlyDeduction)

}

fun roundTwoDecimals(number: Double) = round(number * 100) / 100


val firstName = "Joe"
val surname = "Soap"
val gender = 'm'
val employeeID = 6143
val grossSalary = 67543.21
val payePercentage = 38.5
val prsiPercentage = 5.2
val annualBonus = 1450.50
val cycleToWorkMonthlyDeduction = 54.33