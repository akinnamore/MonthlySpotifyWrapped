package endpoints

object MonthMapper {

  def getMonth(month: String): String = {
    month match {
      case "01" => "January"
      case "02" => "February"
      case "03" => "March"
      case "04" => "April"
      case "05" => "May"
      case "06" => "June"
      case "07" => "July"
      case "08" => "August"
      case "09" => "Septemper"
      case "10" => "October"
      case "11" => "November"
      case "12" => "December"
      case _ => throw new RuntimeException("Invalid month")
    }
  }

}