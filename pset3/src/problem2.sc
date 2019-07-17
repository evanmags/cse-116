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
import scala.collection.immutable.List

class SparseVector(members: Float*){
  val hash: Map[Int, Float] = Map()
  for(n <- 0 until members.length){
    if(members(n) != 0) hash += (n -> members(n))
  }

  def values(): Seq[Float] = {
    return hash.values.toList
  }

  private def toVector(): List[Float] = {
    val max: Int = hash.keys.max
    
    var result: List[Float] = List()


    for(i <- 0 to max){
      if(hash.get(i) == None){
        result = 0::result
      } else {
        result = hash(i)::result
      }
    }

    return result.reverse
  }

  def sum(other: SparseVector): SparseVector = { 
    var summed: List[Float] = List()
    val self: List[Float] = toVector()

    for(i <- 0 until self.length){
      if(other.hash.get(i) != None){
        summed = (self(i) + other.hash(i))::summed
      }
      else {
        summed = self(i)::summed
      }
    }
    
    return new SparseVector(summed.reverse: _*)
  }

  def difference(other: SparseVector): SparseVector = { 
    var diff: List[Float] = List()
    val self: List[Float] = toVector()

    for(i <- 0 until self.length){
      if(other.hash.get(i) != None){
        diff = (self(i) - other.hash(i))::diff
      }
      else {
        diff = self(i)::diff
      }
    }
    
    return new SparseVector(diff.reverse: _*)
  }

  def scalarMult(scalar: Float): SparseVector = {
    var prod: List[Float] = List()
    val self: List[Float] = toVector()

    for (value <- self){
      prod = (value * scalar)::prod
    }

    return new SparseVector(prod.reverse: _*)
  }

  private def multiply(other: SparseVector): SparseVector = { 
    var prod: List[Float] = List()
    val self: List[Float] = toVector()

    for(i <- 0 until self.length){
      if(other.hash.get(i) != None){
        prod = (self(i) * other.hash(i))::prod
      }
      else {
        prod = 0::prod
      }
    }
    
    return new SparseVector(prod.reverse: _*)
  }

  def dot(other: SparseVector): Float = {
    multiply(other).values.sum
  }
}

// sparse vectors are combining incorrectly

object Test_Sparse { // Change to correct object name
  def main(args: Array[String]): Unit = {
    val s1 = new SparseVector(0, 1, 0, 2, 0, 3)
    val s2 = new SparseVector(3, 0, 0, 1, 0, 1)

    println(s1.sum(s2).hash) // good
    // (3, 1, 0, 3, 0, 4)
    println(s1.difference(s2).hash) // good
    // (-3, 1, 0, 1, 0, 2)
    println(s1.scalarMult(3).hash)
    // (0, 3, 0, 6, 0, 9)
    println(s1.dot(s2))
    // 5
    println(s1.cross(s2))

  }
}