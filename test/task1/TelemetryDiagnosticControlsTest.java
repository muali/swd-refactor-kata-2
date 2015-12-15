package task1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TelemetryDiagnosticControlsTest {

  private final String diagnosticMessageResult = "Test diagnostic message";

  private TelemetryClient makeTelemetryClient(final int attemptBeforeConnect) {
    return new TelemetryClient(){

      private int attemptsCount = 0;

      @Override
      public void connect(String telemetryServerConnectionString) {
        if (telemetryServerConnectionString == null || "".equals(telemetryServerConnectionString)) {
          throw new IllegalArgumentException();
        }
        attemptsCount++;
      }

      @Override
      public boolean getOnlineStatus() {
        return attemptsCount == attemptBeforeConnect;
      }

      @Override
      public void disconnect() {
        attemptsCount = 0;
      }

      @Override
      public String receive() {
        return diagnosticMessageResult;
      }

    };
  }

  private TelemetryDiagnosticControls makeTelemetryDiagnosticControls(int clientAttemptsBeforeConnect) {
    return new TelemetryDiagnosticControls(makeTelemetryClient(clientAttemptsBeforeConnect));
  }

  @Test
  public void testDiagnosticInfoProperty() throws Exception {
    TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls();
    telemetryDiagnosticControls.setDiagnosticInfo("aaa");
    assertEquals("aaa", telemetryDiagnosticControls.getDiagnosticInfo());
  }

  @Test
  public void testConnections() throws Exception {
    TelemetryDiagnosticControls telemetryDiagnosticControls = makeTelemetryDiagnosticControls(1);
    telemetryDiagnosticControls.checkTransmission();
    assertEquals(diagnosticMessageResult, telemetryDiagnosticControls.getDiagnosticInfo());
  }

  @Test
  public void testSingleFailConnection() throws Exception {
    TelemetryDiagnosticControls telemetryDiagnosticControls = makeTelemetryDiagnosticControls(2);
    telemetryDiagnosticControls.checkTransmission();
    assertEquals(diagnosticMessageResult, telemetryDiagnosticControls.getDiagnosticInfo());
  }

  @Test
  public void testTwoFailConnection() throws Exception {
    TelemetryDiagnosticControls telemetryDiagnosticControls = makeTelemetryDiagnosticControls(3);
    telemetryDiagnosticControls.checkTransmission();
    assertEquals(diagnosticMessageResult, telemetryDiagnosticControls.getDiagnosticInfo());
  }

  @Test
  public void testDisconnect() throws Exception {
    TelemetryDiagnosticControls telemetryDiagnosticControls = makeTelemetryDiagnosticControls(1);
    telemetryDiagnosticControls.checkTransmission();
    telemetryDiagnosticControls.checkTransmission();
    assertEquals(diagnosticMessageResult, telemetryDiagnosticControls.getDiagnosticInfo());
  }

  @Test(expected = Exception.class)
  public void testOnUnreachableClient() throws Exception {
    TelemetryDiagnosticControls telemetryDiagnosticControls = makeTelemetryDiagnosticControls(4);
    try {
      telemetryDiagnosticControls.checkTransmission();
    } finally {
      assertEquals("", telemetryDiagnosticControls.getDiagnosticInfo());
    }
  }

}
