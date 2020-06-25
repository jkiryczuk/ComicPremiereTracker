package pl.jkir.comicpremieretracker.data

data class Comic (val publisher: String,
                  val description: String,
                  val title: String,
                  val price: String,
                  val creators: String,
                  val release_date: String,
                  val diamond_id: String)