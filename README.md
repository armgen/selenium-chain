# selenium-chain - UTA
unified test automation framework

Throubleshooting InternetExplorerDriver
IE Driver has some very frequent exceptions; those are not related to seleniumQuery, but from the driver itself. You'll find some guidelines on how to solve them below.

Protected Mode exception while launching IE Driver
The message could be like:

Unexpected error launching Internet Explorer. Protected Mode must be set to the same value (enabled or disabled) for all zones.
Or:

org.openqa.selenium.remote.SessionNotFoundException: Unexpected error launching Internet Explorer. Protected Mode settings are not the same for all zones. Enable Protected Mode must be set to the same value (enabled or disabled) for all zones. (WARNING: The server did not provide any stacktrace information)
Some solutions are found below.

Change the Protected Mode in all zones

And as stated in https://code.google.com/p/selenium/issues/detail?id=1795, in IE, go to Tools -> Internet Options -> Security Tab and set all zones to the same protected mode (can be enabled or disabled).

 Security zones

This is also explained in a stackoverflow answer:

It needs to set same Security level in all zones. To do that follow the steps below:

Open IE
Go to Tools -> Internet Options -> Security
Set all zones to the same protected mode, enabled or disabled should not matter.
Finally, set Zoom level to 100% by right clicking on the gear located at the top right corner and enabling the status-bar. Default zoom level is now displayed at the lower right.
