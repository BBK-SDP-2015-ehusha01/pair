import org.junit.Test
import junit.framework.TestCase
import org.junit.Assert._

class TestAI extends TestCase {
 
  private var board: Board = new Board()
  
  // Tests for createGameTree method
  
  @Test def testCreateGameTree() {
     var testMove: Move = new Move(RED, 2)
     board.makeMove(testMove)
     
     var testState: State = new State(RED, board, testMove)
     testState.initializeChildren()
     AI.createGameTree(testState, 2)
     assertNotNull(testState.children)
  }
  
  // Tests for minimax method
  
  @Test def testMinimax() {
     var testMove: Move = new Move(RED, 2)
     board.makeMove(testMove)
     
     var testState: State = new State(RED, board, testMove)
     testState.initializeChildren()
     AI.minimax(new AI(RED, 2), testState)
     assertNotNull(testState.value)
  }
  
  // Tests for getMoves method
  
  @Test def testGetMoves() {
     var testMove: Move = new Move(RED, 2)
     board.makeMove(testMove)
     
     var testState: State = new State(RED, board, testMove)
     testState.initializeChildren()
     
     var aiPlayer = new AI(RED, 2)
     
     AI.minimax(aiPlayer, testState)
     assertTrue(aiPlayer.getMoves(board).length > 0)
  }
}