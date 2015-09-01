# bitlists
Treating Scala Ints as if they were lists of bits, because... why not?

## Use

toInt: Int  
isEmpty: Boolean  
nonEmpty: Boolean  
size: Int  
head: Int  
tail: Bitlist  
map: Seq[B]  
flatMap: Seq[B]  
foreach: Unit  
reduce: Int  
parity: Int  
reverse: Bitlist  

```Bitlist.make(1, 0, 1, 1)``` will make a Bitlist for 11.  
```Bitlist.makeFromSeq(List(1,0,1,1))``` will do the same, though of course you could do Bitlist.make(List(1,0,1,1): _*)
