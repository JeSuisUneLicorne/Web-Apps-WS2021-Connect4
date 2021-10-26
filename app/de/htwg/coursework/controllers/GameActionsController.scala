/*
  MIT License

  Copyright (c) 2021 Daniel Özyurt, Julian Zimmermann

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in all
  copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
  SOFTWARE.
 */

package de.htwg.coursework.controllers

// Play imports
import javax.inject._
import play.api._
import play.api.mvc._

@Singleton
class GameActionsController @Inject() (
    val controllerComponents: ControllerComponents
) extends BaseController {
  private val gameControllerAdapter: GameControllerAdapter =
    new GameControllerAdapter

  def restartGame(): Action[AnyContent] = Action {
    gameControllerAdapter.emptyBoard
    Ok(de.htwg.coursework.views.html.index(gameControllerAdapter))
  }

  def dropDiscAt(columnIndex: Int): Action[AnyContent] = Action {
    gameControllerAdapter.dropDiscAt(columnIndex)
    Ok(de.htwg.coursework.views.html.index(gameControllerAdapter))
  }

  def boardToJson(): Action[AnyContent] = Action {
    Ok(gameControllerAdapter.boardToJson)
  }
}
