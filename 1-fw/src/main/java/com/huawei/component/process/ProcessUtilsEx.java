package com.huawei.component.process;

import java.io.InputStream;

import com.huawei.component.log.LogUtilsEx;

public class ProcessUtilsEx {
	// #region Const

	private static final boolean IS_DEBUG = false;

	// #endregion

	// #region save for research...

	// // #region Fields
	//
	// // #region Construction
	//
	// private static ProcessUtilsEx m_oInstance;
	//
	// public synchronized static ProcessUtilsEx getInstance() {
	// if (null == m_oInstance) {
	// m_oInstance = new ProcessUtilsEx();
	// }
	// return m_oInstance;
	// }
	//
	// // #endregion
	//
	// // #region basicInfo
	//
	// private String m_strDirPathRoot;
	//
	// private List<ProcessCommand> m_lstCmd = new ArrayList<ProcessCommand>();
	//
	// private IProcessCallback m_oIProcessCallback;
	//
	// // #endregion
	//
	// // #region transientInfo
	//
	// @Setter
	// @Getter
	// private boolean isRunning = false;
	//
	// @Setter
	// @Getter
	// private int resultCode = 0;
	//
	// private StringBuffer allResult = new StringBuffer();
	//
	// // #endregion
	//
	// // #endregion
	//
	// // #region init
	//
	// public void init(IProcessCallback oIProcessCallback, String
	// strDirPathRoot, String... lstCmd) {
	// this.m_oIProcessCallback = oIProcessCallback;
	//
	// this.m_strDirPathRoot = strDirPathRoot;
	//
	// for (String strCmd : lstCmd) {
	// ProcessCommand oProcessCommand = new ProcessCommand();
	// if (m_strDirPathRoot != null) {
	// oProcessCommand.setDirectory(m_strDirPathRoot);
	// }
	// oProcessCommand.setCommand(strCmd);
	// m_lstCmd.add(oProcessCommand);
	// }
	// }
	//
	// // #endregion
	//
	// // #region start
	//
	// public void start() {
	// this.isRunning = true;
	//
	// for (ProcessCommand oProcessCommand : m_lstCmd) {
	// ProcessBuilder oProcessBuilder = new ProcessBuilder();
	//
	// if (m_strDirPathRoot != null) {
	// oProcessBuilder.directory(new File(oProcessCommand.getDirectory()));
	// }
	// oProcessBuilder.redirectErrorStream(false);
	// oProcessBuilder.command(oProcessCommand.getCommand());
	// try {
	// exec(oProcessBuilder.start());
	// } catch (InterruptedException e) {
	// LogUtilsEx.log("[ProcessProvider]err..." + e.getMessage(), IS_DEBUG);
	// } catch (IOException e) {
	// LogUtilsEx.log("[ProcessProvider]err..." + e.getMessage(), IS_DEBUG);
	// }
	// }
	// }
	//
	// private void exec(final Process oProcess) throws InterruptedException {
	// BufferedReader oBufferedReaderStdout = new BufferedReader(new
	// InputStreamReader(oProcess.getInputStream()));
	// BufferedReader oBufferedReaderStderr = new BufferedReader(new
	// InputStreamReader(oProcess.getErrorStream()));
	// Thread execThread = new Thread() {
	// public void run() {
	// try {
	// String strTmp1 = oBufferedReaderStdout.readLine();
	// String strTmp2 = oBufferedReaderStderr.readLine();
	// while (strTmp1 != null || strTmp2 != null) {
	// if (strTmp1 != null) {
	// allResult.append(strTmp1 + "\n");
	// m_oIProcessCallback.onNewStdoutListener(strTmp1);
	// }
	// if (strTmp2 != null) {
	// allResult.append(strTmp2 + "\n");
	// m_oIProcessCallback.onNewStderrListener(strTmp2);
	// }
	// }
	// } catch (IOException e) {
	// LogUtilsEx.log("[ProcessUtilsEx]ex..." + e.getMessage(), IS_DEBUG);
	// }
	// resultCode = oProcess.exitValue();
	// }
	// };
	// execThread.start();
	// execThread.join();
	// isRunning = false;
	// m_oIProcessCallback.onProcessFinish(resultCode);
	// }
	//
	// // #endregion
	//
	// // #region destroy
	//
	// public void destroy() {
	// m_strDirPathRoot = null;
	// m_lstCmd.clear();
	// m_oIProcessCallback = null;
	// isRunning = false;
	// resultCode = 0;
	// allResult = new StringBuffer();
	// }
	//
	// // #endregion

	// #endregion

	// #region execSimple

	public static String execSimple(String strCmd, String strCmdArgs) {
		StringBuilder strRes = new StringBuilder();

		try {
			ProcessBuilder oProcessBuilder = new ProcessBuilder(strCmd, strCmdArgs);
			Process oProcess = oProcessBuilder.start();
			InputStream oInputStream = oProcess.getInputStream();
			int iCharCode;
			while ((iCharCode = oInputStream.read()) != -1) {
				strRes.append((char) iCharCode);
			}
			oProcess.waitFor();
		} catch (Exception ex) {
			LogUtilsEx.log("[ProcessUtilsEx]ex..." + ex.getMessage(), IS_DEBUG);
		}

		return strRes.toString();
	}

	// #endregion
}
