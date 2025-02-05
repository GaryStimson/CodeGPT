package ee.carlrobert.codegpt.predictions

import com.intellij.codeInsight.hint.HintManagerImpl
import com.intellij.codeInsight.inline.completion.*
import com.intellij.openapi.actionSystem.*
import com.intellij.openapi.editor.Caret
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.editor.actionSystem.EditorAction
import com.intellij.openapi.editor.actionSystem.EditorWriteActionHandler
import ee.carlrobert.codegpt.CodeGPTKeys

class TriggerCustomPredictionAction : EditorAction(Handler()), HintManagerImpl.ActionToIgnore {

    companion object {
        const val ID = "codegpt.triggerCustomPrediction"
    }

    private class Handler : EditorWriteActionHandler() {

        override fun doExecute(editor: Editor, caret: Caret?, dataContext: DataContext?) {
            val e = InlineCompletionEvent.DirectCall(editor, editor.caretModel.currentCaret, dataContext)
            InlineCompletion.getHandlerOrNull(editor)?.invoke( e )
        }

        override fun isEnabledForCaret(
            editor: Editor,
            caret: Caret,
            dataContext: DataContext
        ): Boolean {
            return editor.getUserData(CodeGPTKeys.EDITOR_PREDICTION_DIFF_VIEWER) == null
        }
    }
}