---- Programmet

Systemet består av två program: Ett klientprogram och ett serverprogram.

Först startar man serverprogrammet därefter klientprogrammet.
När anslutningen är upprätthållen kan man börja skicka kommandon som servern ska utföra.

---- Kommandon
-- Logga in
login;'username';'password'
-- Lägga till ett record
addrecord;'recordid';'nurseid';'patientid';'content'
-- Ta bort ett record
delrecord;'recordid'
-- Editera ett record
editrecord;'recordid';'newcontent'
-- Hämta record information
getrecord;'recordid'

---- Användare
Där finns 4 olika användare med 4 olika rättigheter registerade, alla i samma division.
Användar informationen finns sparad i userdata.txt i serverFiles med följande format:
userid;username;sha-1(password+salt);userlevel;divisionid

Användarnamn	Lösenord	Behörighet
--------------------------------------------------
userpatient		pass		Patients behörighet			
userdoctor		pass		Doktors behörighet
usernurse		pass		Sjusköterska behörighet
usergov			pass		Statlig myndighets behörighet

------ Packet
---- client
-- ClientMain
Huvudklassen med main metoden för att köra server programmet
---- server
--ServerMain
Huvudklassen med main metoden för att köra server programmet
-- CommandClass
En superklass för alla kommandoklasser (Klasserna som startar på "Command").
-- CommandLibrary
Hanterar parsandet av kommandosträng för att sedan utföra det specefika kommandot.
-- HashCrypt
Innehåller statiska metoder för kryptering och hashning.
-- LoginManager
Håller koll på user och login processen.
-- Record
Innehåller information om en record, som tex. innehåll,nurseid och doktorid.
-- User
Innehåller informatioon om en User, som tex. userid, userlevel och UserInformation klassen.
-- UserInformation
Finns där för ha övrig implementering av övrig information om användaren.
-- PasswordInvalidException
Exception då lösenordet är fel.
-- UserNotFoundException
Exception då användaren inte kan hittas.