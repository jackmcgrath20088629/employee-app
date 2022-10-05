package models

import java.lang.Math.round

fun roundTwoDecimals(number: Double) = round(number * 100) / 100


class Employee(var firstName: String, var surname: String, var gender: Char, var employeeID: Int,
               var grossSalary: Double, var payePercentage: Double, var prsiPercentage: Double,
               var annualBonus: Double, var cycleToWorkMonthlyDeduction: Double) {

    fun getFullName() = when (gender) {
        'm', 'M' -> "Mr. ${firstName} $surname}"
        'f', 'F' -> "Ms.  ${firstName} ${surname}"
        else -> "${firstName} ${surname}"
    }


    fun getMonthlySalary() = roundTwoDecimals(grossSalary / 12)
    fun getMonthlyPRSI() = roundTwoDecimals(getMonthlySalary() * (prsiPercentage / 100))
    fun getMonthlyPAYE() = roundTwoDecimals(getMonthlySalary() * (payePercentage / 100))
    fun getGrossMonthlyPay() = roundTwoDecimals(getMonthlySalary() + (annualBonus / 12))
    fun getTotalMonthlyDeductions() = roundTwoDecimals((getMonthlyPRSI() + getMonthlyPAYE() + cycleToWorkMonthlyDeduction))
    fun getNetMonthlyPay() = (getGrossMonthlyPay() - getTotalMonthlyDeductions())

    fun getPayslip() :String {


        return(
            """
        ______________________________________________________________________
         Monthly Payslip:             ${getFullName()}, EmployeeID: ${employeeID}                 
        ______________________________________________________________________    
         Pay Details :) (gross pay: ${getGrossMonthlyPay()})                                                                    
        ______________________________________________________________________
         Salary: ${getMonthlySalary()}
         Bonus:  ${roundTwoDecimals(annualBonus / 12)}            
        ______________________________________________________________________
         Deduction Details :( (total Deductions: ${getTotalMonthlyDeductions()})      
        ______________________________________________________________________
         PAYE: ${getMonthlyPAYE()}               
         PRSI: ${getMonthlyPRSI()} 
         Cycle To Work: ${cycleToWorkMonthlyDeduction}        
        ______________________________________________________________________
         Net pay: ${getNetMonthlyPay()} 
        ______________________________________________________________________"""
        )
    }

    override fun toString(): String {
        return "Employee(firstName='$firstName', surname='$surname', gender=$gender, employeeID=$employeeID, grossSalary=$grossSalary, payePercentage=$payePercentage, prsiPercentage=$prsiPercentage, annualBonus=$annualBonus, cycleToWorkMonthlyDeduction=$cycleToWorkMonthlyDeduction)"
    }
}