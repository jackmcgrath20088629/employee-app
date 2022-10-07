
import models.Employee
import controllers.EmployeeAPI
import mu.KotlinLogging
import kotlin.math.round
import com.github.ajalt.mordant.rendering.TextColors.*
import com.github.ajalt.mordant.rendering.TextStyles.*

var employees = EmployeeAPI()
val logger = KotlinLogging.logger {}
fun main(args: Array<String>){
    logger.info { "Launching Employee App" }
    start()
}

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

        employees.create(Employee(firstName, surname, gender, 0, grossSalary, payePercentage, prsiPercentage, annualBonus, cycleToWorkMonthlyDeduction))
    }
fun list(){
    employees.findAll()
        .forEach{ println(it.toString()) }
}


    var input : Int = 0


fun menu() : Int {
    print(blue(""" 
         |Employee Menu
         |1. Add Employee
         |2. List All Employees
         |3. Search Employees 
         |4. Print Payslip for Employee
         |0. Exit
         |       
         |Enter Option : """.trimMargin()))
    return readLine()!!.toInt()
}

fun start() {
    var input: Int

    do {
        input = menu()
        when (input) {
            1 -> add()
            2 -> list()
            3 -> search()
            4 -> paySlip()
            -99 -> dummyData()
            0 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
}

fun search() {
    val employee = getEmployeeById()
    if (employee == null)
        println("They got fired :(")
    else
        println(employee)
}
internal fun getEmployeeById(): Employee? {
    print("Enter the employee ID to search by: ")
    val employeeID = readLine()!!.toInt()
    return employees.findOne(employeeID)
}
fun paySlip(){
    val employee = getEmployeeById()
    if (employee != null)
        println(employee.getPayslip())
}

fun dummyData() {
    employees.create(Employee("Jeff", "Bing", 'm', 0, 35645.43, 31.0, 7.5, 2000.0, 25.6))
    employees.create(Employee("Steve", "Smith", 'm', 1, 57855.13, 39.5, 7.0, 1500.0, 55.3))
    employees.create(Employee("Lisa", "Harp", 'f', 2, 95985.41, 30.0, 8.5, 4500.0, 0.0))
}


//fun roundTwoDecimals(number: Double) = "%.2f".format(number).toDouble()



