object caesarCipher extends App{

  val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

  val ENC=(c:Char,key:Int,a:String)=>
    a((a.indexOf(c.toUpper)+key)%a.size)

  val DEC=(c:Char,key:Int,a:String)=>
    a(if(a.indexOf(c)<key) a.length-key+a.indexOf(c)
    else(a.indexOf(c.toUpper)-key)%a.size)

  val cipher=(algo:(Char,Int,String)=>
    Char,s:String,key:Int,a:String)=>
    s.map(algo(_,key,a))

  val ct=cipher(ENC,"zip",5,alphabet)
  println(ct)

  val pt=cipher(DEC,ct,5,alphabet)
  println(pt)
}
