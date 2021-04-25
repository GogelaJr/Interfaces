fun main() {
    val subject = Subjectclass()
    val caller1 = Caller()
    val caller2 = Caller2()
    val test1 = TestClass1()
    val test = TestClass()
    println("1) Properties")
    println("TestClass")
    test.printer()
    test.gadaxtoma()
    test.gadagdeba()
    println("TestClass1")
    test1.printer()
    println("2) Inheritance")
    println("SubjectClass")
    subject.flName()
    println("3) Conflict Resolution")
    println("First Callerclass for Colors!")
    caller1.green()
    caller1.red()
    println("Second Callerclass for Colors!")
    caller2.green()
    caller2.red()
    println("4) Conversion")
    println("Aris 4 luwi? - ${Example.yay(4)}")

}

/*ინტერფეისის მაგალითი*/
interface TestInterface {
    fun gadaxtoma()  //ესეთი მეთოდი Defaultზე აბსტრაქტულია
    fun gadagdeba(){
        println("gadagdeba metodi ar aris abstraqtuli")
    }
}

//იმპლემენტაციის მაგალითი
class TestClass: TestInterface, TestInterface1{
    override val ricxvi = 25
    override fun gadaxtoma() {
       println("gadaxtoma metodi abstraqtulia")
    }
//    override fun gadagdeba() {
//
//    }
}
//თვისება ინტერფეისში
interface TestInterface1{
    val ricxvi: Int //თვისებები ინტერფეისში Defaultზე აბსტრაქტულია
    val teqsti: String //აბსტრაქტულია
        get() = "Gamarjoba" // getter ით ვაწვდით teqsti-ს სტრინგს რომელიც კლასიდან უნდა მოხდეს override
    fun printer(){
        println(ricxvi)
        println(teqsti)

    }
}
class TestClass1: TestInterface1{
    override val ricxvi: Int = 5 //ვაწვდით მნიშვნელობას ინტერფეისში
    override val teqsti: String = "Aq Gamarjobas Gadaecera!" // ვაწვდით მნიშვნელობას ინტერფეისში

}
//მემკვიდრეობა ინტერფეისში
interface Subject1 {
    val name: String
    fun flName(){
        println(name)
    }
}
interface Subject2: Subject1 {
    val fName: String
    val lName: String

    override val name: String get() = "$fName $lName" //Subject1 ინტერფეისში აწვდის  თვისებას და აწერს ინფორმაციას

}


class Subjectclass(
    override val fName: String =  "Avtandil ",// აწვდის თვისებას Subject2-ს
    override val lName: String =  "Shoshiashvili" // აწვდის თვისებას Subject2-ს
) : Subject2


//კონფლიქტები

interface Inter1 {
    fun green(){
        println("1st. Green!")
    }
    fun red() //აბსტრაქტულია
}
interface Inter2 {
    fun green() {
        println("2nd. Green!")
    }
    fun red() {
        println("2nd. Red!")
    }
}
class Caller : Inter1{
    override fun red() {
        println("1st. Red!")
    }
}
class Caller2 : Inter1, Inter2 {
    override fun green(){
        super<Inter1>.green() // ვუთითებთ კონკრეტულად რომელი ინტერფეისის მეთოდი დააიმპლემენტოს
        super<Inter2>.green()
    }
    override fun red(){
        super.red()
    }
}
//კონვერსია
fun interface Conversion {
    fun yay(i: Int): Boolean
}

val Example = Conversion { it % 2 == 0 }
