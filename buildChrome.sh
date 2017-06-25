cd chrome-background-example/
sbt chromeUnpackedFast

cd ../chrome-content-example/
sbt fastOptJS

cd ../chrome-popup-example/
sbt fastOptJS

cd ..

#copy content script js files
cp chrome-content-example/target/scala-2.12/content-script-example-fastopt.js chrome-background-example/target/chrome/unpacked-fast/
cp chrome-content-example/target/scala-2.12/content-script-example-jsdeps.js chrome-background-example/target/chrome/unpacked-fast/

cp chrome-popup-example/target/scala-2.12/popup-window-example-fastopt.js chrome-background-example/target/chrome/unpacked-fast/
cp chrome-popup-example/target/scala-2.12/popup-window-example-jsdeps.js chrome-background-example/target/chrome/unpacked-fast/
cp chrome-popup-example/src/main/resources/html/popup.html chrome-background-example/target/chrome/unpacked-fast/

manifestPath=chrome-background-example/target/chrome/unpacked-fast/manifest.json
manifest=$(<$manifestPath)

#remove last bracket
manifest=${manifest::-1}

#add content script
manifest=$"$manifest,\"browser_action\": {
    \"default_popup\": \"popup.html\"
  },\"content_scripts\": [
    {
      \"matches\": [\"*://*/*\"],
      \"js\": [\"content-script-example-jsdeps.js\", \"content-script-example-fastopt.js\"]
    }
  ]
}"
echo "$manifest" > "$manifestPath"