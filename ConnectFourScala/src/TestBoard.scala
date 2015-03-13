import org.junit.Test
import junit.framework.TestCase
import org.junit.Assert._

class TestBoard extends TestCase {
 
  private var board: Board = new Board()
  
  // Tests for MakeMove Method
  
  @Test def testMakeMoveMethod1() {
     var testMove: Move = new Move(RED, 2)
     board.makeMove(testMove)
     assertNotNull(board.getTile(Board.NUM_ROWS - 1, 2))
  }
  
   @Test def testMakeMoveMethod2() {
     var testMove: Move = new Move(YELLOW, 2)
     board.makeMove(testMove)
     assertNotNull(board.getTile(Board.NUM_ROWS - 1, 2))
  }
  
  // Test GetPossibleMoves Method
  
  @Test def testGetPossibleMovesRed() {
    assertTrue(board.getPossibleMoves(RED).length > 0)
  }
  
  @Test def testGetPossibleMovesYellow() {
    assertTrue(board.getPossibleMoves(YELLOW).length > 0)
  }
  
  @Test def testGetPossibleMovesWhenNotPossible() {
    // Fill Board
    (Board.NUM_ROWS - 1 to 0 by -1).foreach { r =>
      (Board.NUM_COLS - 1 to 0 by -1).foreach { c =>
         var testMove: Move = new Move(YELLOW, c)
         board.makeMove(testMove)
      }
    }

    assertEquals(0, board.getPossibleMoves(YELLOW).length)
  }
}