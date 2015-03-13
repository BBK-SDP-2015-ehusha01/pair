import org.junit.Test
import junit.framework.TestCase
import org.junit.Assert._

class TestState extends TestCase {
 
  private var board: Board = new Board()
  
  // Tests for MakeMove Method
  
  @Test def testInitializeChildren() {
     var testMove: Move = new Move(RED, 2)
     board.makeMove(testMove)
     
     var testState: State = new State(RED, board, testMove)
     testState.initializeChildren()
     assertTrue(testState.children.length > 0)
  }
}