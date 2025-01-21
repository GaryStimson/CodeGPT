package ee.carlrobert.codegpt.telemetry;

import ee.carlrobert.codegpt.telemetry.core.service.TelemetryMessageBuilder.ActionMessage;

public enum TelemetryAction {

  COMPLETION("GizmoGPT-Completion"),
  COMPLETION_ERROR("GizmoGPT-Completion-Error"),
  IDE_ACTION("GizmoGPT-Action"),
  IDE_ACTION_ERROR("GizmoGPT-Action-Error"),
  SETTINGS_CHANGED("GizmoGPT-Settings-Changed");

  private final String code;

  TelemetryAction(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }

  public ActionMessage createActionMessage() {
    return TelemetryMessageProvider.builder().action(getCode());
  }
}
