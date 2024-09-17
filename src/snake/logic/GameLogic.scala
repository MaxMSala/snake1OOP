package snake.logic

import engine.random.{RandomGenerator, ScalaRandomGen}
import snake.logic.GameLogic._

import scala.collection.mutable

/** To implement Snake, complete the ``TODOs`` below.
 *
 * If you need additional files,
 * please also put them in the ``snake`` package.
 */


class GameLogic(val random: RandomGenerator,
                val gridDims : Dimensions) {

  var body : List[Point] = List(Point(2,0), Point(1,0), Point(0,0))
  var buffer : Int = 0

  //var apple : Point
  var currDirection: Direction = East()
  var nextPoint : Point = (Point(3,0))

  //def recalcApple(body : mutable.ArrayDeque[Point]): Unit = {
  //  for (p <- gridDims.allPointsInside) {
  //    for (x <- )
  //  }
  //}

  def recalcBody( nextPoint : Point) {

    body = nextPoint :: body
    if (buffer <= 0) {
      body = body.init
    } else {
      buffer -= 1
    }
  }

  // TODO implement me
  def getCellType(searchPoint: Point): CellType = {
    for (p <- body) {
      if (p == searchPoint) {
        if (p != body.head) {
          return SnakeBody()
        } else return SnakeHead(currDirection)
      }
    }
    //if (searchPoint == apple) {
    //  return Apple()
    //} else {
      return Empty()
    //}
  }

  // TODO implement me
  def step() {
    //getCellType(nextPoint) match {
      //case Apple() => {
      //    buffer = 3
      //    recalcApple(body)
      //}
      //case SnakeBody("") => {
        //gameOver = true
     // }
    //}

    currDirection match {
      case East() => {
          nextPoint = Point(body(0).x + 1, body(0).y)
      }
      case West() => {
          nextPoint = Point(body(0).x - 1, body(0).y)
      }
      case South() => {
          nextPoint = Point(body(0).x , body(0).y + 1)
      }
      case North() => {
          nextPoint = Point(body(0).x , body(0).y - 1)
      }
    }

    if (nextPoint.x > gridDims.width - 1){
      nextPoint = Point(0, nextPoint.y)
    } else if (nextPoint.x < 0){
      nextPoint = Point(gridDims.width, nextPoint.y)
    } else if (nextPoint.y > gridDims.height - 1){
      nextPoint = Point(nextPoint.x, 0)
    } else if (nextPoint.y < 0){
      nextPoint = Point(nextPoint.x, gridDims.height)
    }
    recalcBody(nextPoint)
  }

  // TODO implement me
  def changeDir(d: Direction): Unit = {
    currDirection = d

    //currDirection match {
    //  case East() => {
    //    if (body(0).x + 1 > gridDims.width) {
    //      nextPoint = Point(body(0).x - gridDims.width, body(0).y)
    //    } else {
    //      nextPoint = Point(body(0).x + 1, body(0).y)
    //    }
    //  }
    //  case West() => {
    //    if (body(0).x + 1 > gridDims.width) {
    //      nextPoint = Point(body(0).x + gridDims.width, body(0).y)
    //    } else {
    //      nextPoint = Point(body(0).x - 1, body(0).y)
    //    }
    //  }
    //  case South() => {
    //    if (body(0).x + 1 > gridDims.width) {
    //      nextPoint = Point(body(0).x , body(0).y - gridDims.height)
    //    } else {
    //      nextPoint = Point(body(0).x , body(0).y + 1)
    //    }
    //  }
    //  case North() => {
    //    if (body(0).x + 1 > gridDims.width) {
    //      nextPoint = Point(body(0).x , body(0).y + gridDims.height)
    //    } else {
    //      nextPoint = Point(body(0).x , body(0).y - 1)
    //    }
    //  }
    //}
  }

  def gameOver: Boolean = false
  
  // TODO implement me
  def setReverse(r: Boolean): Unit = ()

}

/** GameLogic companion object */
object GameLogic {

  val FramesPerSecond: Int = 5 // change this to increase/decrease speed of game

  val DrawSizeFactor = 1.0 // increase this to make the game bigger (for high-res screens)
  // or decrease to make game smaller

  // These are the dimensions used when playing the game.
  // When testing the game, other dimensions are passed to
  // the constructor of GameLogic.
  //
  // DO NOT USE the variable DefaultGridDims in your code!
  //
  // Doing so will cause tests which have different dimensions to FAIL!
  //
  // In your code only use gridDims.width and gridDims.height
  // do NOT use DefaultGridDims.width and DefaultGridDims.height
  val DefaultGridDims
    : Dimensions =
    Dimensions(width = 25, height = 25)  // you can adjust these values to play on a different sized board



}


