build:
	./mvnw clean package -q

run: build
	ttyd --writable java --enable-native-access=ALL-UNNAMED -jar target/tetris-terminal-game-1.0-SNAPSHOT.jar

deploy: build
	docker build -t tetris-cli-game .
	docker tag tetris-cli-game altnbsmehmet/tetris-terminal-game
	docker push altnbsmehmet/tetris-terminal-game