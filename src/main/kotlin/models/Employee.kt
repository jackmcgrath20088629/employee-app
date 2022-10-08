package models
//https://github.com/ajalt/mordant <---- reference for the colors in the console
import com.github.ajalt.mordant.rendering.TextColors.*
import com.github.ajalt.mordant.rendering.TextStyles.*
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

//The colors alternate between red and green for the lines and actual text of the payslip
        return(
            """
        ${red("______________________________________________________________________")}
        ${green("Monthly Payslip:             ${getFullName()} , EmployeeID: ${employeeID}")}
        ${red("______________________________________________________________________")}
        ${green("Pay Details :) (gross pay: ${getGrossMonthlyPay()})")}
        ${red("______________________________________________________________________")}
        ${green("Salary: ${getMonthlySalary()}")}
        ${green("Bonus:  ${roundTwoDecimals(annualBonus / 12)}")}
        ${red("______________________________________________________________________")}
        ${green("Deduction Details :( (total Deductions: ${getTotalMonthlyDeductions()})")}
        ${red("______________________________________________________________________")}
        ${green("PAYE: ${getMonthlyPAYE()}")}
        ${green("PRSI: ${getMonthlyPRSI()}")}
        ${green("Cycle To Work: ${cycleToWorkMonthlyDeduction}")}
        ${red("______________________________________________________________________")}
        ${green(" Net pay: ${getNetMonthlyPay()}")}
        ${red("______________________________________________________________________")}
""")
    }

    override fun toString(): String {
        return "Employee(firstName='$firstName', surname='$surname', gender=$gender, employeeID=$employeeID, grossSalary=$grossSalary, payePercentage=$payePercentage, prsiPercentage=$prsiPercentage, annualBonus=$annualBonus, cycleToWorkMonthlyDeduction=$cycleToWorkMonthlyDeduction)"
    }
}