# wicket-jquery-ui
**jQuery UI & Kendo UI integration in Wicket 7.x, Wicket 8.x &amp; Wicket9.x**  
[![TravisCI](https://travis-ci.org/sebfz1/wicket-jquery-ui.svg?branch=wicket8.x)](https://travis-ci.org/sebfz1/wicket-jquery-ui)

## Getting started
In order to get started using this API, you may download appropriate jar(s) or set a maven dependency.

### Download jar(s)
If you are not using maven, you need to download the core jar here:
<http://central.maven.org/maven2/com/googlecode/wicket-jquery-ui/>

You may also download other jars as required (ie: `wicket-kendo-ui`).  
Once done, just include the jar(s) in your project's build path.

### Using Maven

```xml
<dependency>
    <groupId>com.googlecode.wicket-jquery-ui</groupId>
    <artifactId>wicket-jquery-ui</artifactId>
    <version>8.14.0</version>
</dependency>
```
```xml
<dependency>
    <groupId>com.googlecode.wicket-jquery-ui</groupId>
    <artifactId>wicket-kendo-ui</artifactId>
    <version>8.14.0</version>
</dependency>
```

If the version you specified is *snapshot*, you might define this repository:

```xml
<repositories>
    <repository>
        <id>sonatype-snapshots</id>
        <name>Sonatype Snapshots Repository</name>
        <url>http://oss.sonatype.org/content/repositories/snapshots/</url>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
    </repository>
</repositories>
```

### Versions

<table>
<tr><th>wicket-jquery-ui</th><th>Wicket</th><th>jQuery UI</th></tr>
<tr><td>8.14.0</td><td>8.14.0</td><td>1.13.2</td></tr>
<tr><td>8.13.0</td><td>8.13.0</td><td>1.13.1</td></tr>
<tr><td>8.12.0</td><td>8.12.0</td><td>1.12.1</td></tr>
<tr><td>8.11.0</td><td>8.11.0</td><td>1.12.1</td></tr>
<tr><td>8.10.0</td><td>8.10.0</td><td>1.12.1</td></tr>
<tr><td>8.9.0</td><td>8.9.0</td><td>1.12.1</td></tr>
<tr><td>8.8.0</td><td>8.8.0</td><td>1.12.1</td></tr>
<tr><td>8.6.0</td><td>8.6.0</td><td>1.12.1</td></tr>
<tr><td>8.3.0</td><td>8.3.0</td><td>1.12.1</td></tr>
<tr><td>8.1.0</td><td>8.1.0</td><td>1.12.1</td></tr>
<tr><td>8.0.0</td><td>8.0.0</td><td>1.12.1</td></tr>
<tr><td>8.0.0-M9</td><td>8.0.0-M9</td><td>1.12.1</td></tr>
<tr><td>8.0.0-M8</td><td>8.0.0-M8</td><td>1.12.1</td></tr>
<tr><td>8.0.0-M7</td><td>8.0.0-M7</td><td>1.12.1</td></tr>
<tr><td>8.0.0-M6</td><td>8.0.0-M6</td><td>1.12.1</td></tr>
<tr><td>8.0.0-M5</td><td>8.0.0-M5</td><td>1.12.1</td></tr>
<tr><td>8.0.0-M4</td><td>8.0.0-M4</td><td>1.12.1</td></tr>
<tr><td>8.0.0-M3</td><td>8.0.0-M3</td><td>1.12.1</td></tr>
<tr><td>8.0.0-M2</td><td>8.0.0-M2</td><td>1.12.0</td></tr>
<tr><td>8.0.0-M1</td><td>8.0.0-M1</td><td>1.12.0</td></tr>
</table>

<table>
<tr><th>wicket-kendo-ui</th><th>Wicket</th><th>Kendo UI</th></tr>
<tr><td>9.14.0</td><td>9.14.0</td><td>2022.3.913 (ASFv2)</td></tr>
<tr><td>8.13.0</td><td>8.13.0</td><td>2021.3.914 (ASFv2)</td></tr>
<tr><td>8.12.0</td><td>8.12.0</td><td>2021.1.119 (ASFv2)</td></tr>
<tr><td>8.11.0</td><td>8.11.0</td><td>2021.1.119 (ASFv2)</td></tr>
<tr><td>8.10.0</td><td>8.10.0</td><td>2020.3.915 (ASFv2)</td></tr>
<tr><td>8.9.0</td><td>8.9.0</td><td>2020.3.915 (ASFv2)</td></tr>
<tr><td>8.8.0</td><td>8.8.0</td><td>2019.2.619 (ASFv2)</td></tr>
<tr><td>8.6.0</td><td>8.6.0</td><td>2019.2.619 (ASFv2)</td></tr>
<tr><td>8.3.0</td><td>8.3.0</td><td>2019.1.220 (ASFv2)</td></tr>
<tr><td>8.1.0</td><td>8.1.0</td><td>2018.1.117 (ASFv2)</td></tr>
<tr><td>8.0.0</td><td>8.0.0</td><td>2018.1.117 (ASFv2)</td></tr>
<tr><td>8.0.0-M9</td><td>8.0.0-M9</td><td>2018.1.117 (ASFv2)</td></tr>
<tr><td>8.0.0-M8</td><td>8.0.0-M8</td><td>2017.3.913 (ASFv2)</td></tr>
<tr><td>8.0.0-M7</td><td>8.0.0-M7</td><td>2017.2.621 (ASFv2)</td></tr>
<tr><td>8.0.0-M6</td><td>8.0.0-M6</td><td>2017.2.504 (ASFv2)</td></tr>
<tr><td>8.0.0-M5</td><td>8.0.0-M5</td><td>2017.1.223 (ASFv2)</td></tr>
<tr><td>8.0.0-M4</td><td>8.0.0-M4</td><td>2016.3.1118 (ASFv2)</td></tr>
<tr><td>8.0.0-M3</td><td>8.0.0-M3</td><td>2016.3.1118 (ASFv2)</td></tr>
<tr><td>8.0.0-M2</td><td>8.0.0-M2</td><td>2016.3.1028 (ASFv2)</td></tr>
<tr><td>8.0.0-M1</td><td>8.0.0-M1</td><td>2016.2.714 (ASFv2)</td></tr>
</table>

## Setting up the jQuery UI theme

### Using standard themes
To use wicket-jquery-ui with a standard theme, just add the corresponding theme dependency to your webapp pom

```xml
<dependency>
	<groupId>com.googlecode.wicket-jquery-ui</groupId>
	<artifactId>wicket-jquery-ui-theme-uilightness</artifactId>
	<version>8.14.0</version>
</dependency>
```

### Using a custom theme
Please follow the instruction on [How to change resource references](https://github.com/sebfz1/wicket-jquery-ui/wiki/%5Bhowto%5D-change-resource-references)

## Setting up the Kendo UI theme

### Using standard themes
To use wicket-kendo-ui with a standard theme, just add the corresponding theme dependency to your webapp pom

```xml
<dependency>
	<groupId>com.googlecode.wicket-jquery-ui</groupId>
	<artifactId>wicket-kendo-ui-theme-default</artifactId>
	<version>8.14.0</version>
</dependency>
```

### Using a custom theme
Please follow the instruction on [How to change resource references](https://github.com/sebfz1/wicket-jquery-ui/wiki/%5Bhowto%5D-change-resource-references)

## You are now ready to use wicket-jquery-ui!
Look at the samples provided in the demo site to get started with the code...  
<http://www.7thweb.net/wicket-jquery-ui>

