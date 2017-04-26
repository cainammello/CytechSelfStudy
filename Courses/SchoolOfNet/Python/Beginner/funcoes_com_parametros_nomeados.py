def call_numbers():
	for number in range(0, 10):
		print(number)

def call_numbers_with_limit(limit):
	list = range(0,10)

	for number in list[0:limit]:
		print(number)
		
	print("Limit reached!")
		
#call_numbers()
#call_numbers_with_limit(5)

def calculator(x,y):
	return x+y

result = calculator(y=10, x=5)
print("Result is", result)