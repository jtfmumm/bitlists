package com.jtfmumm.collections.bitlists


case class Bitlist(n: Int) {
  private val lnOf2 = Math.log(2) // natural log of 2
  private def log2(x: Double): Double = Math.log(x) / lnOf2

  def toInt: Int = n
  def isEmpty: Boolean = n == 0
  def nonEmpty: Boolean = !isEmpty
  val size: Int = log2(n).toInt + 1
  def head: Int = n & 1
  def tail: Bitlist = Bitlist(n >> 1)

  def map[B](f: Int => B): Seq[B] = {
    def loop(l: Bitlist, acc: Seq[B]): Seq[B] = l match {
      case a if a.isEmpty => acc
      case _ => loop(l.tail, f(l.head) +: acc)
    }
    loop(this, Seq[B]())
  }
  def flatMap[B](f: Int => Seq[B]): Seq[B] = {
    def loop(l: Bitlist, acc: Seq[B]): Seq[B] = l match {
      case a if a.isEmpty => acc
      case _ => loop(l.tail, f(l.head) ++ acc)
    }
    loop(this, Seq[B]())
  }
  def foreach(f: Int => Unit): Unit = {
    f(head)
    if (tail.nonEmpty) tail.foreach(f)
  }
  def reduce(f: (Int, Int) => Int): Int = {
    if (this.isEmpty) return 0
    def loop(l: Bitlist, acc: Int): Int = l match {
      case x if x.isEmpty => acc
      case _ => loop(l.tail, f(acc, l.head))
    }
    loop(this.tail, this.head)
  }

  def parity: Int = reduce((x, y) => x + y) % 2

  def reverse: Bitlist = {
    def loop(l: Seq[Int], acc: Int = 0): Int = l match {
      case a if a.isEmpty => acc
      case _ => loop(l.tail, (acc << 1) + l.head)
    }
    Bitlist(loop(this.map((x: Int) => x).reverse))
  }

  override def toString: String = {
    map(_.toString).mkString
  }
}

object Bitlist {
  def make(l: Int*): Bitlist = {
    val intFromSeq = l.reduce((acc, x) => {
      if (x != 0 && x != 1) throw new RuntimeException("You can only make a Bitlist from a series of 1s and 0s!")
      (acc << 1) + x
    })
    new Bitlist(intFromSeq)
  }
  def makeFromSeq(l: Seq[Int]): Bitlist = {
    make(l: _*)
  }
}

