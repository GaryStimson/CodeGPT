package ee.carlrobert.codegpt.toolwindow.chat;

public enum ChatToolWindowType {
  CODEGPT_CHAT("GizmoGPT Chat"),
  CODEGPT_CHAT_WITHOUT_PERSONA("GizmoGPT Chat without Persona"),
  CODEGPT_CHAT_WITH_PERSONA("GizmoGPT Chat with Persona");

  private final String name;

  ChatToolWindowType(String name) {
    this.name = name;
  }
}
