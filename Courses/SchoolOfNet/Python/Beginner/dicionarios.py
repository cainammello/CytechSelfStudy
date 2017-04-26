cars = {}

cars['colora']  = 'red'
cars['ferrari'] = 'blue'
cars['fuska'] = 'black'

#primeira forma de retornar items e valor
for car in cars:
	print(car + " = " + cars[car])

#forma mais elegante de retornar items e valor
for key, value in cars.items():
	print(key + " = " + value)
