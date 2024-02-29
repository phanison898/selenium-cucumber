package com.custom.exceptions;

public class ExpectKnownException {

	public static void selectBrowser(String selectedBrowser) throws NoSuchBrowserException {

		String[] validBrowsers = { "chrome", "firefox", "edge" };

		boolean isAvailable = false;
		for (String browser : validBrowsers) {
			if (selectedBrowser.equalsIgnoreCase(browser)) {
				isAvailable = true;
				break;
			}
		}

		if (!isAvailable) {

			StringBuilder messageBuilder = new StringBuilder();

			messageBuilder.append(String.format(
					"Selected browser [ %s ] isn't available. Select any one of these browsers {", selectedBrowser));

			int i = 0;
			for (String browser : validBrowsers) {
				i++;

				messageBuilder.append(String.format(" %s ", browser));

				if (validBrowsers.length != i) {
					messageBuilder.append(",");
				}

			}
			messageBuilder.append("}");

			throw new NoSuchBrowserException(messageBuilder.toString());
		}

	}

	public static void selectCMDHeadlessMode() throws InvalidMavenArgumentException {
		String mode = System.getProperty("headless");

		if (mode != null) {

			if (!(mode.equalsIgnoreCase("true") || mode.equalsIgnoreCase("false"))) {
				throw new InvalidMavenArgumentException(String.format(
						"Invalid value [%s] passed for -Dheadless argument. Pass either 'true' or 'false'", mode));
			}

		}
	}

}
