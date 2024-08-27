run-dist:
	make -C app run-dist

clean:
	make -C app clean

build:
	make -C app clean build

run:
	make -C app run

test:
	make -C app test

report:
	make -C app report

lint:
	make -C app lint

.PHONY: build