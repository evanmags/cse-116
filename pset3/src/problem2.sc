//
// Exercise #10 in the Day02 exercise assignment describes a sparse vector implementation based on the scala collection type named “map”. This exercise will require you to define a class named sparseVector and to create methods in the class that perform the operations vector sum, vector difference, scalar-times-vector multiplication, vector dot-product and vector cross-product.
// A useful reference, although not complete, is
// 		https://www.britannica.com/science/vector-operations
// It is, of course, necessary for methods performing operations on two vectors, to receive an argument of type sparseVector. Thus the method for computing a vector sum will be     def sum(other : sparseVector) : sparseVector  = {
// And will compute the vector sum of (a) the vector object in which the sum is called and, (b) the “other” vector, named as the parameter to the method. Include a method to convert a List to a sparseVector.
// Testing:
// Exercise all methods with both large and small vectors.
// Class methods will insure that:
//  All vectors are numeric only (elements are either Integer or Double).
//  All vectors are actually sparse (at least 75% of the elements are 0).
//  The code that you submit must be yours, not from some website.
//

import scala.collection.mutable.Map

class SparseVector(members: Float*){
  // constructor
  val hash: Map[Int, Float] = Map()
  for(n <- 0 until members.length){
    if(members(n) != 0) hash += (n -> members(n))
  }

  private def +(a: Float, b: Float): Float = a + b
  private def -(a: Float, b: Float): Float = a - b
  private def *(a: Float, b: Float): Float = a * b
  private def toVector(): List[Float] = {
    val max: Int = hash.keys.max
    val result: Seq[Float] = for(i <- 0 to max) yield {
      if(hash.get(i) == None) 0
      else hash(i)
    }
    result.toList
  }
  private def opperate(other: SparseVector, op: (Float, Float) => Float): SparseVector = { 
    val self: List[Float] = toVector()
    val res: Seq[Float] = for(i <- 0 until self.length) yield {
      if(other.hash.get(i) != None) op(self(i), other.hash(i))
      else if (op(5, 4) == *(5, 4)) 0 // inefficent but it works
      else self(i)
    }
    return new SparseVector(res.toList: _*)
  }

  def values(): List[Float] = hash.values.toList
  def sum(other: SparseVector): SparseVector = opperate(other, +)
  def difference(other: SparseVector): SparseVector = opperate(other, -)
  def dot(other: SparseVector): Float = opperate(other, *).values.sum
  def scalarMult(scalar: Float): SparseVector = {
    val self: List[Float] = toVector()
    val prod = for (value <- self) yield (value * scalar)

    return new SparseVector(prod.toList: _*)
  }
}

object Test_Sparse {
  def main(args: Array[String]): Unit = {
    val s1 = new SparseVector(0, 1, 0, 2, 0, 3)
    val s2 = new SparseVector(3, 0, 0, 1, 0, 1)

    println(s1.sum(s2).hash) // (3, 1, 0, 3, 0, 4)
    println(s1.difference(s2).hash) // (-3, 1, 0, 1, 0, 2)
    println(s1.scalarMult(3).hash) // (0, 3, 0, 6, 0, 9)
    println(s1.dot(s2)) // 5
  }
}