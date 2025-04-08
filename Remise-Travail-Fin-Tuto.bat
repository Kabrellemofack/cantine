@ECHO OFF
CHCP 65001 >NUL
PROMPT $G
CD /D "%~dp0"
CD ..

SET        PATH_ROOT=C:\DEV25
SET    PATH_EXE_7ZIP=%PATH_ROOT%\utils\bin\7z.exe

SET      NOM_EI=Tuto Web Java

:: Zaclys
SET    URL_VISU_1=https://acloud10.zaclys.com/index.php/s/fTJH4jPoCTc9Y7c
SET TOKEN_DEPOT_1=CHba7DyDSorXgTE
SET    URL_VISU_2=https://acloud10.zaclys.com/index.php/s/NG6Cp8JxNQLqTfZ
SET TOKEN_DEPOT_2=Fo9EQRpNRDmGTFj
SET    URL_VISU_3=https://acloud10.zaclys.com/index.php/s/p4eLnjJAz6M8jQ7
SET TOKEN_DEPOT_3=BpJzDcxLjkn24ys
SET     URL_DEPOT=https://acloud10.zaclys.com

:: Libretic
SET    URL_VISU_1=https://nextcloud.libretic.fr/s/L99fSW2FkniYpPs
SET TOKEN_DEPOT_1=yqsS7FZDWB3Te72
SET    URL_VISU_2=https://nextcloud.libretic.fr/s/ijQDMKL2D8R9PCJ
SET TOKEN_DEPOT_2=679fpTS8Bpqc742
SET    URL_VISU_3=https://nextcloud.libretic.fr/s/C7WnRC5sDXWPkCP
SET TOKEN_DEPOT_3=nciPEoqCXFzTBbR
SET     URL_DEPOT=https://nextcloud.libretic.fr
	

:: Affiche le nom de l'EI
ECHO.
ECHO.%NOM_EI%
ECHO.

:saisie-groupe
ECHO.
SET GROUPE=
SET /P GROUPE=Quel est votre groupe de TD (1, 2, 3 ou 4) : 
IF "%GROUPE%" == "1" (
  SET    URL_VISU=%URL_VISU_1%
  SET TOKEN_DEPOT=%TOKEN_DEPOT_1%
)
IF "%GROUPE%" == "4" (
  SET    URL_VISU=%URL_VISU_1%
  SET TOKEN_DEPOT=%TOKEN_DEPOT_1%
)
IF "%GROUPE%" == "2" (
  SET    URL_VISU=%URL_VISU_2%
  SET TOKEN_DEPOT=%TOKEN_DEPOT_2%
)
IF "%GROUPE%" == "3" (
  SET    URL_VISU=%URL_VISU_3%
  SET TOKEN_DEPOT=%TOKEN_DEPOT_3%
)
IF "%TOKEN_DEPOT%" == "" (
  GOTO :saisie-groupe
)

:saisie-nom
::Saisie du nom + prénom
ECHO.
SET /P NAME_ARCHIVE=Indiquez votre nom + prénom : 
IF "%NAME_ARCHIVE%"=="" GOTO :saisie-nom

:: Mise en majuscule du nom de l'archive
CALL :toUpper NAME_ARCHIVE "%NAME_ARCHIVE%"

:: Nom et chemin du fichier archive
SET FILE_ARCHIVE=%NAME_ARCHIVE%.zip
SET PATH_ARCHIVE=.\%FILE_ARCHIVE%

:: Paramètres de 7-Zip
SET ARGS_7Z=a "%PATH_ARCHIVE%"
SET ARGS_7Z=%ARGS_7Z% cantine*/src/main/java
SET ARGS_7Z=%ARGS_7Z% cantine*/src/main/resources/db
SET ARGS_7Z=%ARGS_7Z% cantine*/src/main/resources/templates
SET ARGS_7Z=%ARGS_7Z% tuto*/src/main/java
SET ARGS_7Z=%ARGS_7Z% tuto*/src/main/resources/templates
SET ARGS_7Z=%ARGS_7Z% -x!"*/src/main/resources/db/*.lo1"
SET ARGS_7Z=%ARGS_7Z% -mx
 
:: Crée l'archive
IF EXIST "%PATH_ARCHIVE%" DEL "%PATH_ARCHIVE%"
"%PATH_EXE_7ZIP%" %ARGS_7Z%

:: Envoie le fichier
ECHO.
CALL :formaURL URL_DEST "%URL_DEPOT%/public.php/webdav/%FILE_ARCHIVE%"
::curl -T "%PATH_ARCHIVE%" -u "%TOKEN_DEPOT%":"" "%URL_DEST%"

::EcHO. & PAUSE
::goto :eof

SET count=0
FOR /F "tokens=* USEBACKQ" %%F IN (`curl --version`) DO (
  CALL SET /A count=%%count%% + 1
)
IF "%count%" == "0" (
  ECHO   ┌─────────────────────┐
  ECHO   │ Echec du transfert  │
  ECHO   └─────────────────────┘ 
  ECHO. & PAUSE
  GOTO :EOF
)

SET count=0
FOR /F "tokens=* USEBACKQ" %%F IN (`curl -T "%PATH_ARCHIVE%" -u "%TOKEN_DEPOT%":"" "%URL_DEST%"`) DO (
  CALL SET /A count=%%count%% + 1
  ECHO %%F
)
IF NOT errorlevel 1 IF "%count%" == "0" GOTO :open-visu
ECHO   ┌─────────────────────┐
ECHO   │ Echec du transfert  │
ECHO   └─────────────────────┘ 
ECHO. & PAUSE
GOTO :EOF

:open-visu
:: Ouvre la page de vérification visuelle
START "" "%URL_VISU%"

:: Ouvre l'explorateur de fichiers de Windows
::ping localhost -n 3 > NUL 
::explorer /n,..

:: Fin du traitement
::ECHO. & PAUSE
GOTO :EOF

:: Procédure de mise en majuscule
:toUpper <return_var> <str>
FOR /f "usebackq delims=" %%I IN (`powershell "\"%~2\".toUpper()"`) DO SET "%~1=%%~I"
GOTO :EOF

:: Procédure de normalisaton d'url
:formaURL <return_var> <str>
FOR /f "usebackq delims=" %%I IN (`powershell "\"%~2\".replace(' ', '%%20' )"`) DO SET "%~1=%%~I"
GOTO :EOF
