import java.util.List
import AI._
//remove if not needed
import scala.collection.JavaConversions._

object AI {

  def createGameTree(s: State, d: Int) {
    s.initializeChildren()
    if (d <= 1) return
    s.children.foreach { c => createGameTree(c, d - 1) }
  }

  def minimax(ai: AI, s: State) {
    ai.minimax(s)
  }
}

class AI(private var player: Player, private var depth: Int) extends Solver {

  override def getMoves(b: Board): Array[Move] = {
    b.getPossibleMoves(player)
  }

  def minimax(s: State) {
      if (s.children.isEmpty) {
        s.value = evaluateBoard(s.board)
        return
      }
      
      s.children.foreach(minimax)
      
      s.value = if (s.player == player) s.children.maxBy(st => st.value).value else s.children.minBy(st => st.value).value
  }

  def evaluateBoard(b: Board): Int = {
    val winner = b.hasConnectFour()
    var value = 0
    if (winner == null) {
      val locs = b.winLocations()
      for (loc <- locs; p <- loc) {
        value += (if (p == player) 1 else if (p != null) -1 else 0)
      }
    } else {
      var numEmpty = 0
      var r = 0
      while (r < Board.NUM_ROWS) {
        var c = 0
        while (c < Board.NUM_COLS) {
          if (b.getTile(r, c) == null) numEmpty += 1
          c = c + 1
        }
        r = r + 1
      }
      value = (if (winner == player) 1 else -1) * 10000 * numEmpty
    }
    value
  }
}

