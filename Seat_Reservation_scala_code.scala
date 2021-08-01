import scala.io.StdIn._

object Seat_Resevation {

  def main(args:Array[String]){

    var input= 0
    var count= 0
    var i= 0
    var j= 0
    var signal= 0
    var row= 0
    var column= 0
    var seatCount= 0

    val seats= Array.ofDim[String](40,40)
    val posts= Array("Executive_Director","Management_Director","Marketing_Director","President","Labourer")

    for(i<-0 to 8){
      for(j<- 0 to 5){
        seats(i)(j)= "Available\t\t"
      }
    }

    while(count<8){

      for(i<-0 to 8){
        for(j<- 0 to 5){

          if(seats(i)(j)==posts(count)){
            seats(i)(j)= "Available\t\t"
          }
        }
      }
      count=count+1
      signal=0

      while(signal != -1){
        println("\n\t\t\t\t\t\t\t*** [This is the current resevation] ***\n")
        println("     0 \t\t\t\t     1 \t\t\t\t     2 \t\t\t\t     3 \t\t\t\t     4 \t\t\t\t     5 \t\t\t\t   ")
        for(i<-0 to 8){
          print(i + " ")
          for(j<- 0 to 5){
            print(seats(i)(j) + "\t ")
          }
          println()
        }

      print("\nNumber of seats need to reserve: " )
      seatCount = readInt()
      for(k<-0 to seatCount-1){
        println("\n*** [Enter the row number and the column number of the seat you want to reserve] ***")
        print("\nRow: ")
        row = readInt()
        print("Column: ")
        column = readInt()

        if(seats(row)(column)!= "Available\t\t"){
          println("\t*** [This seat is already Reserved] ***\n")
        }
        else{
          print("\n\t*** [Select the employer] ***\n")
          print("1) Executive Director\n")
          print("2) Management Director\n")
          print("3) Marketing Director\n")
          print("4) President\n")
          print("5) Labourer\n")
          print("\nEnter the relevant No: ")
          var s = readInt()

          def sel_emp(a: Int)= a match{

            case 1 => {seats(row)(column) = "Exec Dir\t\t"}
            case 2 => {seats(row)(column) = "Man Dir\t\t"}
            case 3 => {seats(row)(column) = "Mark Dir\t\t"}
            case 4 => {seats(row)(column) = "President\t\t"}
            case 5 => {seats(row)(column) = "Labourer\t\t"}
            case _ => print("Invalid Position")
          }

         sel_emp(s)

        }
      }
      print("\nDo you want to continue:\n if yes enter: 1\n if no enter: -1 ")
      signal = readInt()
      }
    }
    println("Seats successfully received!\n")
  }
}
