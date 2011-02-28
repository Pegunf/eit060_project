---- Programmet

Systemet best�r av tv� program: Ett klientprogram och ett serverprogram.

F�rst startar man serverprogrammet d�refter klientprogrammet.
N�r anslutningen �r uppr�tth�llen kan man b�rja skicka kommandon som servern ska utf�ra.

---- Kommandon
-- Logga in
login;'username';'password'
-- L�gga till ett record
addrecord;'recordid';'nurseid';'patientid';'content'
-- Ta bort ett record
delrecord;'recordid'
-- Editera ett record
editrecord;'recordid';'newcontent'
-- H�mta record information
getrecord;'recordid'

---- Anv�ndare
D�r finns 4 olika anv�ndare med 4 olika r�ttigheter registerade, alla i samma division.
Anv�ndar informationen finns sparad i userdata.txt i serverFiles med f�ljande format:
userid;username;sha-1(password+salt);userlevel;divisionid

Anv�ndarnamn	L�senord	Beh�righet
--------------------------------------------------
userpatient		pass		Patients beh�righet			
userdoctor		pass		Doktors beh�righet
usernurse		pass		Sjusk�terska beh�righet
usergov			pass		Statlig myndighets beh�righet

------ Packet
---- client
-- ClientMain
Huvudklassen med main metoden f�r att k�ra server programmet
---- server
--ServerMain
Huvudklassen med main metoden f�r att k�ra server programmet
-- CommandClass
En superklass f�r alla kommandoklasser (Klasserna som startar p� "Command").
-- CommandLibrary
Hanterar parsandet av kommandostr�ng f�r att sedan utf�ra det specefika kommandot.
-- HashCrypt
Inneh�ller statiska metoder f�r kryptering och hashning.
-- LoginManager
H�ller koll p� user och login processen.
-- Record
Inneh�ller information om en record, som tex. inneh�ll,nurseid och doktorid.
-- User
Inneh�ller informatioon om en User, som tex. userid, userlevel och UserInformation klassen.
-- UserInformation
Finns d�r f�r ha �vrig implementering av �vrig information om anv�ndaren.
-- PasswordInvalidException
Exception d� l�senordet �r fel.
-- UserNotFoundException
Exception d� anv�ndaren inte kan hittas.