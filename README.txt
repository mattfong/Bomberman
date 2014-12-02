Authors
-------------------------------------------
Yahya Azami
yahya.azami@mail.mcgill.ca

Matthew Fong
Matthew.fong@mail.mcgill.ca

Philip Hoddinott
philip.hoddinott@mail.mcgill.ca

Kirththiga Murugupillai
kirththiga.murugupillai@mail.mcgill.ca	


Licensing
----------------------------------------------------------------------
All rights reserved © Yahya Azami, Matthew Fong, Philip Hoddinott, Kirththiga Murugupillai


External Dependencies
----------------------------
Java 7 or newer Java Runtime Environments.


Development conditions
----------------------------------
Application tested on x64 windows 8.1 machines, compiled using the JDK 1.7 and developped using Eclipse.



Required Dependencies
----------------------------------------
opencsv-3.0.jar
http://opencsv.sourceforge.net/
To install add opencsv to buildpath. The application contains opencsv pre-packaged



Source Code Location
----------------------------------------------
https://github.com/mcgill-ecse321/Team-7


ANT File
-----------------------------------------------
<project name="Bomberman07" default="compile" basedir=".">
	<property name="src" location="src"/>
	<property name="lib" location="lib"/>
	<property name="res" location="res"/>
	<property name="build" location="bin"/>
	<property name="dist"  location="dist"/>
	<property name="doc"  location="doc"/>
		
	<target name="clean">
		<!-- 
			Delete our directories. 
		-->
		<delete dir="${build}"/>
		<delete dir="${dist}"/>
		<delete dir="${doc}"/>
	</target>

	<target name="compile" depends="clean">
		<!-- Create the build directory. -->
		<mkdir dir="${build}"/>
		<!-- 
			Compile all of the source files. 
			Make sure to include libraries. 
		-->
		<javac srcdir="${src}" destdir="${build}">
			<classpath>
				<fileset dir="${lib}">
					<include name="**/*.jar"/>
				</fileset>
			</classpath>
		</javac>
		<!-- Copy our resources. -->
		<copy todir="${build}">
		    <fileset dir="${res}"/>
		</copy>
	</target>
	
	<target name="jar" depends="compile">
		<!-- Create our dist folder. -->
		<mkdir dir="${dist}"/>
		<!-- Create the jar file as build.jar -->
		<jar destfile="${dist}/build.jar" filesetmanifest="mergewithoutmain">
			<!-- Specify the class which has the main method. -->
			<manifest>
				<attribute name="Main-Class" value="menuView.PanelTransitionManager"/>
				<attribute name="Class-Path" value="."/>
			</manifest>
			<!-- Add in our compiled files. -->
			<fileset dir="${build}"/>
			<!-- Add in our libraries. -->
			<zipgroupfileset dir="${lib}" includes="**/*.jar"/>
		</jar>
	</target>
	
	<target name="doc" depends="clean">
		<!-- Create the doc directory. -->
		<mkdir dir="${doc}"/>
		<!-- Generate the Javadoc. -->
		<javadoc sourcepath="${src}" destdir="${doc}"/>
	</target>
</project>