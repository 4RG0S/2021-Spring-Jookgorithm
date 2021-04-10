RESISTOR_VALUE = {"black": 0, "brown": 1, "red": 2, "orange": 3, "yellow": 4, "green": 5,
                  "blue": 6, "violet": 7, "grey": 8, "white": 9}
RESISTOR_PRODUCT = {"black": 1, "brown": 10, "red": 100, "orange": 1000, "yellow": 10000,
                    "green": 100000, "blue": 1000000, "violet": 10000000, "grey": 100000000, "white": 1000000000}
value1 = RESISTOR_VALUE[input()]
value2 = RESISTOR_VALUE[input()]
value3 = RESISTOR_PRODUCT[input()]
print(value1 * value3 * 10 + value2 * value3)
