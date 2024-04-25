!classDefinition: #EmpresaTest category: #tp2_2!
TestCase subclass: #EmpresaTest
	instanceVariableNames: 'unaEmpresa unEmpPer unEmpTem unEmpCont unCalendario'
	classVariableNames: ''
	poolDictionaries: ''
	category: 'tp2_2'!

!EmpresaTest methodsFor: 'tests-recibo' stamp: 'mnk 4/9/2024 10:09:40'!
test026_reciboHaberesEmpleadoPermanente
	
	| unRecibo |
	self inicializarEmpresaYEmpleados.
	unCalendario setFechaDeHoy: (March/26/2024).
	unRecibo := ReciboHaberes Empleado: unEmpPer calendario: unCalendario.
	
	Assert
		that: unRecibo reciboContent isEqualTo:
'Nombre del empleado: hjk
Direccion: 857
Fecha de emision: March 26, 2024
Sueldo bruto: 100.0
Sueldo neto: 75.0
Desgloce de conceptos:
	Asignacion por hijo: 0
	Asignacion por conyugue: 0
	Por antiguedad: 0
	Obra social: 10.0
	Aportes jubilatorios: 15.0
'.

	Assert
		that: unEmpPer sueldoBruto isEqualTo: 100.0.
	Assert
		that: unEmpPer sueldoNeto isEqualTo: 75.0.
	Assert
		that: unEmpPer montoAsigHijo isEqualTo: 0! !

!EmpresaTest methodsFor: 'tests-recibo' stamp: 'mnk 4/9/2024 10:12:13'!
test027_reciboHaberesEmpleadoTemporaria
	
	| unRecibo |
	self inicializarEmpresaYEmpleados.
	unCalendario setFechaDeHoy: (March/26/2024).
	unRecibo := ReciboHaberes Empleado: unEmpTem calendario: unCalendario.
	
	Assert
		that: unRecibo reciboContent isEqualTo:
'Nombre del empleado: hjk
Direccion: 857
Fecha de emision: March 26, 2024
Sueldo bruto: 100.0
Sueldo neto: 80.0
Desgloce de conceptos:
	Por horas extras: 0
	Obra social: 10.0
	Aportes jubilatorios: 10.0
'.

	Assert
		that: unEmpTem sueldoBruto isEqualTo: 100.0.
	Assert
		that: unEmpTem sueldoNeto isEqualTo: 80.0.
	Assert
		that: unEmpTem montoHorasExtras isEqualTo: 0! !

!EmpresaTest methodsFor: 'tests-recibo' stamp: 'mnk 4/9/2024 10:15:02'!
test034_reciboHaberesEmpleadoContratado
	
	| unRecibo |
	self inicializarEmpresaYEmpleados.
	unCalendario setFechaDeHoy: (March/26/2024).
	unRecibo := ReciboHaberes Empleado: unEmpCont calendario: unCalendario.
	
	Assert
		that: unRecibo reciboContent isEqualTo:
'Nombre del empleado: hjk
Direccion: 857
Fecha de emision: March 26, 2024
Sueldo bruto: 100.0
Sueldo neto: 50.0
Desgloce de conceptos:
	Gastos administrativos contractuales: 50
'.

	Assert
		that: unEmpCont sueldoBruto isEqualTo: 100.0.
	Assert
		that: unEmpCont sueldoNeto isEqualTo: 50.0.
	Assert
		that: unEmpCont montoGastosAdCont isEqualTo: 50! !


!EmpresaTest methodsFor: 'tests-empresa' stamp: 'mnk 4/9/2024 11:02:56'!
test017_sueldosNetosEmpresaSinEmpleados

	unaEmpresa := Empresa Nombre: 'sdf'
		cuit: 759
		calendario: unCalendario.
	
	Assert
		that:	unaEmpresa totalSueldosNeto isEqualTo: 0

! !

!EmpresaTest methodsFor: 'tests-empresa' stamp: 'mnk 4/9/2024 11:10:07'!
test018_sueldosNetosEmpresaCon1Empleado

	self inicializarEmpresaYEmpleados.
	unaEmpresa addEmpleado: unEmpCont .
	
	Assert
		that:	unaEmpresa totalSueldosNeto isEqualTo: unEmpCont sueldoNeto
	! !

!EmpresaTest methodsFor: 'tests-empresa' stamp: 'mnk 4/9/2024 11:10:36'!
test019_sueldosNetosEmpresaNoPuedeTener2VecesAlMismoEmpleado

	self inicializarEmpresaYEmpleados.
	unaEmpresa addEmpleado: unEmpCont.
	unaEmpresa addEmpleado: unEmpCont.
	
	Assert
		that:	unaEmpresa totalSueldosNeto isEqualTo: unEmpCont sueldoNeto
	! !

!EmpresaTest methodsFor: 'tests-empresa' stamp: 'mnk 4/9/2024 11:00:56'!
test020_sueldosNetosEmpresaConEmpleadosDeDistintasCategorias

	self inicializarEmpresaYEmpleados.
	unaEmpresa addEmpleado: unEmpPer.
	unaEmpresa addEmpleado: unEmpTem.
	unaEmpresa addEmpleado: unEmpCont.
	
	Assert
		that:	unaEmpresa totalSueldosNeto
		isEqualTo: unEmpPer sueldoNeto + unEmpTem sueldoNeto + unEmpCont sueldoNeto
	! !

!EmpresaTest methodsFor: 'tests-empresa' stamp: 'mnk 4/9/2024 11:09:24'!
test021_sueldosBrutosEmpresaSinEmpleados

	unaEmpresa := Empresa Nombre: 'sdf'
		cuit: 759
		calendario: unCalendario.
	
	Assert
		that:	unaEmpresa totalSueldosBrutos isEqualTo: 0
	! !

!EmpresaTest methodsFor: 'tests-empresa' stamp: 'mnk 4/9/2024 11:11:02'!
test022_sueldosBrutosEmpresaCon1Empleado

	self inicializarEmpresaYEmpleados.
	unaEmpresa addEmpleado: unEmpCont.
	
	Assert
		that:	unaEmpresa totalSueldosBrutos isEqualTo: unEmpCont sueldoBruto
	! !

!EmpresaTest methodsFor: 'tests-empresa' stamp: 'mnk 4/9/2024 11:11:49'!
test023_sueldosBrutosEmpresaConEmpleados

	self inicializarEmpresaYEmpleados.
	unaEmpresa addEmpleado: unEmpPer.
	unaEmpresa addEmpleado: unEmpTem.
	unaEmpresa addEmpleado: unEmpCont.
	
	Assert
		that:	unaEmpresa totalSueldosBrutos
		isEqualTo: unEmpPer sueldoBruto + unEmpTem sueldoBruto + unEmpCont sueldoBruto
	! !

!EmpresaTest methodsFor: 'tests-empresa' stamp: 'mnk 4/9/2024 11:12:01'!
test024_retencionesEmpresaSinEmpleados

	unaEmpresa := Empresa Nombre: 'sdf'
		cuit: 759
		calendario: unCalendario.
	
	Assert
		that:	unaEmpresa totalRetenciones isEqualTo: 0
	! !

!EmpresaTest methodsFor: 'tests-empresa' stamp: 'mnk 4/9/2024 11:12:34'!
test025_retencionesEmpresaConEmpleados

	self inicializarEmpresaYEmpleados.
	unaEmpresa addEmpleado: unEmpPer.
	unaEmpresa addEmpleado: unEmpTem.
	unaEmpresa addEmpleado: unEmpCont.
	
	Assert
		that:	unaEmpresa totalRetenciones
		isEqualTo: unEmpPer retenciones + unEmpTem retenciones + unEmpCont retenciones
	! !

!EmpresaTest methodsFor: 'tests-empresa' stamp: 'mnk 4/9/2024 11:12:48'!
test028_getReciboEmpresaSinEmpleados

	unaEmpresa := Empresa Nombre: 'sdf'
		cuit: 759
		calendario: unCalendario.
	unaEmpresa liquidarSueldos.

	Assert
		that:	unaEmpresa getRecibos size isEqualTo: 0
! !

!EmpresaTest methodsFor: 'tests-empresa' stamp: 'mnk 4/9/2024 11:13:14'!
test029_getReciboEmpresaConEmpleados

	self inicializarEmpresaYEmpleados.
	unaEmpresa addEmpleado: unEmpPer.
	unaEmpresa addEmpleado: unEmpTem.
	unaEmpresa addEmpleado: unEmpCont.
	unaEmpresa liquidarSueldos.

	Assert
		that:	unaEmpresa getRecibos size isEqualTo: 3
! !

!EmpresaTest methodsFor: 'tests-empresa' stamp: 'mnk 4/9/2024 11:14:36'!
test030_getReciboDeEmpleado

	| unRecibo |
	self inicializarEmpresaYEmpleados.
	unCalendario setFechaDeHoy: (March/26/2024).
	unaEmpresa addEmpleado: unEmpPer.
	unaEmpresa addEmpleado: unEmpTem.
	unaEmpresa addEmpleado: unEmpCont.
	unaEmpresa liquidarSueldos.
	
	unRecibo := unaEmpresa getRecibos detect: [:eachRecibo| eachRecibo getEmpleado = unEmpPer ].
	
	Assert
		that:	unRecibo reciboContent isEqualTo:
'Nombre del empleado: hjk
Direccion: 857
Fecha de emision: March 26, 2024
Sueldo bruto: 100.0
Sueldo neto: 75.0
Desgloce de conceptos:
	Asignacion por hijo: 0
	Asignacion por conyugue: 0
	Por antiguedad: 0
	Obra social: 10.0
	Aportes jubilatorios: 15.0
'.! !

!EmpresaTest methodsFor: 'tests-empresa' stamp: 'mnk 4/9/2024 10:16:03'!
test035_getReciboDeEmpleadoContratado

	| unRecibo |
	self inicializarEmpresaYEmpleados.
	unCalendario setFechaDeHoy: (March/26/2024).
	unaEmpresa addEmpleado: unEmpPer.
	unaEmpresa addEmpleado: unEmpTem.
	unaEmpresa addEmpleado: unEmpCont.
	unaEmpresa liquidarSueldos.
	
	unRecibo := unaEmpresa getRecibos detect: [:eachRecibo| eachRecibo getEmpleado = unEmpCont].
	
	Assert
		that:	unRecibo reciboContent isEqualTo:
'Nombre del empleado: hjk
Direccion: 857
Fecha de emision: March 26, 2024
Sueldo bruto: 100.0
Sueldo neto: 50.0
Desgloce de conceptos:
	Gastos administrativos contractuales: 50
'.! !


!EmpresaTest methodsFor: 'tests-empleados' stamp: 'mnk 4/7/2024 09:00:45'!
test001_edadEmpleado

	| unEmpPermanente |
	unEmpPermanente := EmpPermanente Nombre: 'hjk'
		dir:  '857'
		estCivil: 'Soltero'
		fechaNac: (August / 7 / 1986)
		sueldoBasico: 100.00
		cantHijos: 0
		antig: 0.
	
	Assert
		that:	unEmpPermanente edad isEqualTo:  (FixedGregorianDate today distanceFrom: (August / 7 / 1986))! !

!EmpresaTest methodsFor: 'tests-empleados' stamp: 'mnk 4/7/2024 09:08:32'!
test002_sueldoBasico

	| unEmpPermanente |
	unEmpPermanente := EmpPermanente Nombre: 'hjk'
		dir:  '857'
		estCivil: 'Soltero'
		fechaNac: (August / 7 / 1986)
		sueldoBasico: 100.00
		cantHijos: 0
		antig: 0.
	
	Assert
		that:	unEmpPermanente getSueldoBasico isEqualTo: 100.00! !


!EmpresaTest methodsFor: 'factory-methods' stamp: 'mnk 4/9/2024 11:03:21'!
inicializarEmpresaYEmpleados

	unCalendario := Calendario fechaDeHoy.

	unaEmpresa := Empresa Nombre: 'sdf'
		cuit: 759
		calendario: unCalendario.

	unEmpPer := EmpPermanente Nombre: 'hjk'
		dir:  '857'
		estCivil: 'Soltero'
		fechaNac: (August / 7 / 1986)
		sueldoBasico: 100.00
		cantHijos: 0
		antig: 0.

	unEmpTem := EmpTemporaria Nombre: 'hjk'
		dir:  '857'
		estCivil: 'Soltero'
		fechaNac: (August / 7 / 1986)
		sueldoBasico: 100.00
		fechaFin: (January / 1 / 2025)
		cantHorasExtras: 0.

	unEmpCont := EmpContratado Nombre: 'hjk'
		dir:  '857'
		estCivil: 'Soltero'
		fechaNac: (August / 7 / 1986)
		sueldoBasico: 100.00
		numContrato: 90
		medioDePago: 'Cheque'! !


!EmpresaTest methodsFor: 'tests-empTem' stamp: 'mnk 4/7/2024 09:09:10'!
test007_sueldoBrutoEmpTemSinHorasExtras

	| unEmpTemporaria |
	unEmpTemporaria := EmpTemporaria Nombre: 'hjk'
		dir:  '857'
		estCivil: 'Soltero'
		fechaNac: (August / 7 / 1986)
		sueldoBasico: 100.00
		fechaFin: (January / 1 / 2025)
		cantHorasExtras: 0.
	
	Assert
		that:	unEmpTemporaria sueldoBruto isEqualTo: 100.00! !

!EmpresaTest methodsFor: 'tests-empTem' stamp: 'mnk 4/7/2024 09:09:18'!
test008_sueldoBrutoEmpTemConHorasExtras

	| unEmpTemporaria |
	unEmpTemporaria := EmpTemporaria Nombre: 'hjk'
		dir:  '857'
		estCivil: 'Soltero'
		fechaNac: (August / 7 / 1986)
		sueldoBasico: 100.00
		fechaFin: (January / 1 / 2025)
		cantHorasExtras: 1.
	
	Assert
		that:	unEmpTemporaria sueldoBruto isEqualTo: 140.00! !

!EmpresaTest methodsFor: 'tests-empTem' stamp: 'mnk 4/9/2024 10:42:23'!
test011_retencionesEmpTemMenorDe50YSinHorasExtras

	| unEmpTemporaria |
	unEmpTemporaria := EmpTemporaria Nombre: 'hjk'
		dir:  '857'
		estCivil: 'Soltero'
		fechaNac: (FixedGregorianDate today previous: 30*year)
		sueldoBasico: 100.00
		fechaFin: (January / 1 / 2025)
		cantHorasExtras: 0.
	
	Assert
		that:	unEmpTemporaria retenciones isEqualTo: 20! !

!EmpresaTest methodsFor: 'tests-empTem' stamp: 'mnk 4/7/2024 09:07:48'!
test012_retencionesEmpTemCon50AniosYSinHorasExtras

	| unEmpTemporaria |
	unEmpTemporaria := EmpTemporaria Nombre: 'hjk'
		dir:  '857'
		estCivil: 'Soltero'
		fechaNac: (FixedGregorianDate today previous: 50*year)
		sueldoBasico: 100.00
		fechaFin: (January / 1 / 2025)
		cantHorasExtras: 0.
	
	Assert
		that:	unEmpTemporaria retenciones isEqualTo: 20! !

!EmpresaTest methodsFor: 'tests-empTem' stamp: 'mnk 4/9/2024 10:42:43'!
test013_retencionesEmpTemMayorDe50YSinHorasExtras

	| unEmpTemporaria |
	unEmpTemporaria := EmpTemporaria Nombre: 'hjk'
		dir:  '857'
		estCivil: 'Soltero'
		fechaNac: (FixedGregorianDate today previous: 51*year)
		sueldoBasico: 100.00
		fechaFin: (January / 1 / 2025)
		cantHorasExtras: 0.
	
	Assert
		that:	unEmpTemporaria retenciones isEqualTo: 20 + 25! !

!EmpresaTest methodsFor: 'tests-empTem' stamp: 'mnk 4/9/2024 10:43:36'!
test014_retencionesEmpTemMenorDe50YConHorasExtras

	| unEmpTemporaria |
	unEmpTemporaria := EmpTemporaria Nombre: 'hjk'
		dir:  '857'
		estCivil: 'Soltero'
		fechaNac: (FixedGregorianDate today previous: 30*year)
		sueldoBasico: 100.00
		fechaFin: (January / 1 / 2025)
		cantHorasExtras: 1.
	
	Assert
		that:	unEmpTemporaria retenciones isEqualTo: 	14 + 14 + 5! !

!EmpresaTest methodsFor: 'tests-empTem' stamp: 'mnk 4/9/2024 10:43:54'!
test016_sueldoNetoEmpTemMenorDe50YSinHorasExtras

	| unEmpTemporaria |
	unEmpTemporaria := EmpTemporaria Nombre: 'hjk'
		dir:  '857'
		estCivil: 'Soltero'
		fechaNac: (FixedGregorianDate today previous: 30*year)
		sueldoBasico: 100.00
		fechaFin: (January / 1 / 2025)
		cantHorasExtras: 0.
	
	Assert
		that:	unEmpTemporaria sueldoNeto isEqualTo: 100 - 20! !


!EmpresaTest methodsFor: 'tests-empPer' stamp: 'mnk 4/7/2024 09:08:40'!
test003_sueldoBrutoEmpPerSinAntNiFamilia

	| unEmpPermanente |
	unEmpPermanente := EmpPermanente Nombre: 'hjk'
		dir:  '857'
		estCivil: 'Soltero'
		fechaNac: (August / 7 / 1986)
		sueldoBasico: 100.00
		cantHijos: 0
		antig: 0.
	
	Assert
		that:	unEmpPermanente sueldoBruto isEqualTo: 100.00! !

!EmpresaTest methodsFor: 'tests-empPer' stamp: 'mnk 4/7/2024 09:08:46'!
test004_sueldoBrutoEmpPerConAntig

	| unEmpPermanente |
	unEmpPermanente := EmpPermanente Nombre: 'hjk'
		dir:  '857'
		estCivil: 'Soltero'
		fechaNac: (August / 7 / 1986)
		sueldoBasico: 100.00
		cantHijos: 0
		antig: 1.
	
	Assert
		that:	unEmpPermanente sueldoBruto isEqualTo: 150.00! !

!EmpresaTest methodsFor: 'tests-empPer' stamp: 'mnk 4/7/2024 09:08:51'!
test005_1_sueldoBrutoEmpPerCasado

	| unEmpPermanente |
	unEmpPermanente := EmpPermanente Nombre: 'hjk'
		dir:  '857'
		estCivil: 'Casado'
		fechaNac: (August / 7 / 1986)
		sueldoBasico: 100.00
		cantHijos: 0
		antig: 0.
	
	Assert
		that:	unEmpPermanente sueldoBruto isEqualTo: 200.00! !

!EmpresaTest methodsFor: 'tests-empPer' stamp: 'mnk 4/7/2024 09:08:56'!
test005_2_sueldoBrutoEmpPerCasada

	| unEmpPermanente |
	unEmpPermanente := EmpPermanente Nombre: 'hjk'
		dir:  '857'
		estCivil: 'Casada'
		fechaNac: (August / 7 / 1986)
		sueldoBasico: 100.00
		cantHijos: 0
		antig: 0.
	
	Assert
		that:	unEmpPermanente sueldoBruto isEqualTo: 200.00! !

!EmpresaTest methodsFor: 'tests-empPer' stamp: 'mnk 4/7/2024 09:09:02'!
test006_sueldoBrutoEmpPerConHijos

	| unEmpPermanente |
	unEmpPermanente := EmpPermanente Nombre: 'hjk'
		dir:  '857'
		estCivil: 'Viudo'
		fechaNac: (August / 7 / 1986)
		sueldoBasico: 100.00
		cantHijos: 1
		antig: 0.
	
	Assert
		that:	unEmpPermanente sueldoBruto isEqualTo: 250.00! !

!EmpresaTest methodsFor: 'tests-empPer' stamp: 'mnk 4/7/2024 09:09:25'!
test009_retencionesEmpPerSinFamilia

	| unEmpPermanente |
	unEmpPermanente := EmpPermanente Nombre: 'hjk'
		dir:  '857'
		estCivil: 'Soltero'
		fechaNac: (August / 7 / 1986)
		sueldoBasico: 100.00
		cantHijos: 0
		antig: 0.
	
	Assert
		that:	unEmpPermanente retenciones isEqualTo: 10 + 15! !

!EmpresaTest methodsFor: 'tests-empPer' stamp: 'mnk 4/7/2024 09:09:29'!
test010_retencionesEmpPerConHijos

	| unEmpPermanente |
	unEmpPermanente := EmpPermanente Nombre: 'hjk'
		dir:  '857'
		estCivil: 'Viudo'
		fechaNac: (August / 7 / 1986)
		sueldoBasico: 100.00
		cantHijos: 1
		antig: 0.

	Assert
		that:	unEmpPermanente retenciones isEqualTo: 250*0.1 + 20 + (250*0.15).! !

!EmpresaTest methodsFor: 'tests-empPer' stamp: 'mnk 4/7/2024 09:10:16'!
test015_sueldoNetoEmpPerSinAntNiFamilia

	| unEmpPermanente |
	unEmpPermanente := EmpPermanente Nombre: 'hjk'
		dir:  '857'
		estCivil: 'Soltero'
		fechaNac: (August / 7 / 1986)
		sueldoBasico: 100.00
		cantHijos: 0
		antig: 0.
	
	Assert
		that:	unEmpPermanente sueldoNeto isEqualTo: 100 - 25! !


!EmpresaTest methodsFor: 'tests-empCont' stamp: 'mnk 4/7/2024 09:10:43'!
test031_sueldoBrutoEmpContratado

	| unEmpContratado|
	unEmpContratado := EmpContratado Nombre: 'hjk'
		dir:  '857'
		estCivil: 'Soltero'
		fechaNac: (August / 7 / 1986)
		sueldoBasico: 100.00
		numContrato: 90
		medioDePago: 'Cheque'.
		
	
	Assert
		that:	unEmpContratado sueldoBruto isEqualTo: 100.00! !

!EmpresaTest methodsFor: 'tests-empCont' stamp: 'mnk 4/7/2024 09:10:49'!
test032_retencionesEmpContratado

	| unEmpContratado|
	unEmpContratado := EmpContratado Nombre: 'hjk'
		dir:  '857'
		estCivil: 'Soltero'
		fechaNac: (August / 7 / 1986)
		sueldoBasico: 100.00
		numContrato: 90
		medioDePago: 'Cheque'.
		
	
	Assert
		that:	unEmpContratado retenciones isEqualTo: 50.00! !

!EmpresaTest methodsFor: 'tests-empCont' stamp: 'mnk 4/7/2024 09:10:57'!
test033_sueldoNetoEmpContratado

	| unEmpContratado|
	unEmpContratado := EmpContratado Nombre: 'hjk'
		dir:  '857'
		estCivil: 'Soltero'
		fechaNac: (August / 7 / 1986)
		sueldoBasico: 100.00
		numContrato: 90
		medioDePago: 'Cheque'.
		
	
	Assert
		that:	unEmpContratado sueldoNeto isEqualTo: 50.00! !


!classDefinition: #Calendario category: #tp2_2!
Object subclass: #Calendario
	instanceVariableNames: 'fechaDeHoy'
	classVariableNames: ''
	poolDictionaries: ''
	category: 'tp2_2'!

!Calendario methodsFor: 'initialization' stamp: 'mnk 4/9/2024 09:52:08'!
initializeFechaDeHoy
	fechaDeHoy := FixedGregorianDate today! !


!Calendario methodsFor: 'accessing' stamp: 'mnk 4/9/2024 10:07:58'!
getFechaDeHoy

	^ fechaDeHoy! !


!Calendario methodsFor: 'setting' stamp: 'mnk 4/9/2024 10:10:18'!
setFechaDeHoy: aDate

	fechaDeHoy := aDate! !

"-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- "!

!classDefinition: 'Calendario class' category: #tp2_2!
Calendario class
	instanceVariableNames: ''!

!Calendario class methodsFor: 'instance creation' stamp: 'mnk 4/9/2024 09:50:57'!
fechaDeHoy

	^ self new initializeFechaDeHoy! !


!classDefinition: #Empleado category: #tp2_2!
Object subclass: #Empleado
	instanceVariableNames: 'nombre direccion estadoCivil fechaNacimiento sueldoBasico'
	classVariableNames: ''
	poolDictionaries: ''
	category: 'tp2_2'!

!Empleado methodsFor: 'accessing' stamp: 'mnk 4/9/2024 10:25:23'!
edad

	^ FixedGregorianDate today distanceFrom: fechaNacimiento! !

!Empleado methodsFor: 'accessing' stamp: 'mnk 3/24/2024 08:44:45'!
getDireccion

	^ direccion! !

!Empleado methodsFor: 'accessing' stamp: 'mnk 3/24/2024 08:10:31'!
getNombre

	^ nombre! !

!Empleado methodsFor: 'accessing' stamp: 'mnk 3/24/2024 12:04:41'!
getSueldoBasico

	^sueldoBasico! !

!Empleado methodsFor: 'accessing' stamp: 'mnk 3/22/2024 20:41:56'!
retenciones

	^ self retencionObraSocial + self aportesJubilatorios! !

!Empleado methodsFor: 'accessing' stamp: 'mnk 3/23/2024 11:16:04'!
sueldoNeto

	^ self sueldoBruto - self retenciones! !


!Empleado methodsFor: 'initialization' stamp: 'mnk 3/22/2024 08:40:19'!
initializeNombre: aString1 dir: aString2 estCivil: aString3 fechaNac: aDate sueldoBasico: aFloat 

	nombre := aString1.
	direccion := aString2.
	estadoCivil := aString3.
	fechaNacimiento := aDate.
	sueldoBasico := aFloat.! !


!Empleado methodsFor: 'private' stamp: 'mnk 3/23/2024 09:37:02'!
adicionalApJub

	^ 0! !

!Empleado methodsFor: 'private' stamp: 'mnk 3/23/2024 09:31:50'!
aportesJubilatorios

	^ (self factorApJubSueldoBruto) * self sueldoBruto + self adicionalApJub! !

!Empleado methodsFor: 'private' stamp: 'mnk 3/24/2024 12:28:31'!
desglocePara: unRecibo

	self subclassResponsibility! !

!Empleado methodsFor: 'private' stamp: 'mnk 3/26/2024 09:39:43'!
factorApJubSueldoBruto

	^ 0.0! !

!Empleado methodsFor: 'private' stamp: 'mnk 3/22/2024 20:48:35'!
retOSInvariante

	^ 0.1 * self sueldoBruto! !

!Empleado methodsFor: 'private' stamp: 'mnk 3/26/2024 09:38:43'!
retOSVariable

	^ 0.0! !

!Empleado methodsFor: 'private' stamp: 'mnk 3/22/2024 21:21:39'!
retencionObraSocial

	^ self retOSInvariante + self retOSVariable! !

!Empleado methodsFor: 'private' stamp: 'mnk 3/21/2024 12:05:24'!
sueldoBruto
	self subclassResponsibility! !

!Empleado methodsFor: 'private' stamp: 'mnk 3/23/2024 10:04:59'!
unoSiCeroSiNo: aBoolean

	^aBoolean ifTrue: [^1] ifFalse: [^0]! !


!classDefinition: #EmpContratado category: #tp2_2!
Empleado subclass: #EmpContratado
	instanceVariableNames: 'numContrato medioDePago'
	classVariableNames: ''
	poolDictionaries: ''
	category: 'tp2_2'!

!EmpContratado methodsFor: 'initialization' stamp: 'mnk 3/25/2024 10:46:34'!
initializeNumContrato: anInt medioDePago: aString 

	numContrato := anInt.
	medioDePago := aString! !


!EmpContratado methodsFor: 'accessing' stamp: 'mnk 3/25/2024 11:13:53'!
retenciones

	^ self montoGastosAdCont! !

!EmpContratado methodsFor: 'accessing' stamp: 'mnk 3/25/2024 10:49:28'!
sueldoBruto

	^ self getSueldoBasico! !


!EmpContratado methodsFor: 'private' stamp: 'mnk 3/25/2024 11:17:30'!
desglocePara: unRecibo

	unRecibo desgEmpCont: self! !

!EmpContratado methodsFor: 'private' stamp: 'mnk 3/25/2024 11:14:34'!
montoGastosAdCont

	^ 50! !

"-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- "!

!classDefinition: 'EmpContratado class' category: #tp2_2!
EmpContratado class
	instanceVariableNames: ''!

!EmpContratado class methodsFor: 'instance creation' stamp: 'mnk 3/25/2024 10:44:37'!
Nombre: aString1 dir: aString2 estCivil: aString3 fechaNac: aDate sueldoBasico: aFloat numContrato: anInt medioDePago: aString4 

	^self new initializeNombre: aString1 dir: aString2 estCivil: aString3 fechaNac: aDate sueldoBasico: aFloat;
	
		initializeNumContrato: anInt medioDePago: aString4! !


!classDefinition: #EmpPermanente category: #tp2_2!
Empleado subclass: #EmpPermanente
	instanceVariableNames: 'cantHijos antiguedad'
	classVariableNames: ''
	poolDictionaries: ''
	category: 'tp2_2'!

!EmpPermanente methodsFor: 'initialization' stamp: 'mnk 3/22/2024 08:52:03'!
initializeCantHijos: anInt1 antig: anInt2 

	cantHijos := anInt1.
	antiguedad := anInt2! !


!EmpPermanente methodsFor: 'accessing' stamp: 'mnk 3/24/2024 12:04:42'!
sueldoBruto
	^ self getSueldoBasico + self salarioFamiliar + self montoAntig! !


!EmpPermanente methodsFor: 'private' stamp: 'mnk 3/24/2024 12:34:59'!
desglocePara: unRecibo

	unRecibo desgEmpPer: self! !

!EmpPermanente methodsFor: 'private' stamp: 'mnk 3/23/2024 09:36:04'!
factorApJubSueldoBruto

	^ 0.15! !

!EmpPermanente methodsFor: 'private' stamp: 'mnk 3/22/2024 09:00:44'!
montoAntig
	^ 50* antiguedad! !

!EmpPermanente methodsFor: 'private' stamp: 'mnk 3/22/2024 21:11:15'!
montoAsigCony
	^ 100 * (self unoSiCeroSiNo: (self tieneConyugue))! !

!EmpPermanente methodsFor: 'private' stamp: 'mnk 3/22/2024 09:02:42'!
montoAsigHijo
	^ 150 * cantHijos! !

!EmpPermanente methodsFor: 'private' stamp: 'mnk 3/22/2024 21:24:55'!
retOSVariable

	^ 20 * cantHijos! !

!EmpPermanente methodsFor: 'private' stamp: 'mnk 3/22/2024 20:42:58'!
salarioFamiliar
	^ self montoAsigHijo + self montoAsigCony! !

!EmpPermanente methodsFor: 'private' stamp: 'mnk 3/23/2024 08:16:15'!
tieneConyugue

	^ estadoCivil = 'Casado' or: estadoCivil = 'Casada'! !

"-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- "!

!classDefinition: 'EmpPermanente class' category: #tp2_2!
EmpPermanente class
	instanceVariableNames: ''!

!EmpPermanente class methodsFor: 'instance creation' stamp: 'mnk 3/25/2024 10:44:48'!
Nombre: aString1 dir: aString2 estCivil: aString3 fechaNac: aDate sueldoBasico: aFloat cantHijos: anInt1 antig: anInt2
	
	^self new initializeNombre: aString1 dir: aString2 estCivil: aString3 fechaNac: aDate sueldoBasico: aFloat;
	
		initializeCantHijos: anInt1 antig: anInt2! !


!classDefinition: #EmpTemporaria category: #tp2_2!
Empleado subclass: #EmpTemporaria
	instanceVariableNames: 'fechaFin cantHorasExtras'
	classVariableNames: ''
	poolDictionaries: ''
	category: 'tp2_2'!

!EmpTemporaria methodsFor: 'initialization' stamp: 'mnk 3/22/2024 17:06:38'!
initializeFechaFin: aDate cantHorasExtras: anInt 
	
	fechaFin := aDate.
	cantHorasExtras := anInt.! !


!EmpTemporaria methodsFor: 'accessing' stamp: 'mnk 3/24/2024 12:04:41'!
sueldoBruto
	^ self getSueldoBasico + self montoHorasExtras! !


!EmpTemporaria methodsFor: 'private' stamp: 'mnk 3/23/2024 10:42:44'!
adicionalApJub

	^ 5 * cantHorasExtras! !

!EmpTemporaria methodsFor: 'private' stamp: 'mnk 3/24/2024 12:35:41'!
desglocePara: unRecibo

	unRecibo desgEmpTem: self! !

!EmpTemporaria methodsFor: 'private' stamp: 'mnk 3/23/2024 10:14:34'!
edadMayor50

	^(fechaNacimiento next: 50 * year) < FixedGregorianDate today.! !

!EmpTemporaria methodsFor: 'private' stamp: 'mnk 3/23/2024 10:17:47'!
factorApJubSueldoBruto

	^ 0.1! !

!EmpTemporaria methodsFor: 'private' stamp: 'mnk 3/22/2024 17:10:55'!
montoHorasExtras

	^ 40 * cantHorasExtras! !

!EmpTemporaria methodsFor: 'private' stamp: 'mnk 3/23/2024 10:58:30'!
retOSVariable

	^ 25* (self unoSiCeroSiNo: (self edadMayor50))! !

"-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- "!

!classDefinition: 'EmpTemporaria class' category: #tp2_2!
EmpTemporaria class
	instanceVariableNames: ''!

!EmpTemporaria class methodsFor: 'instance creation' stamp: 'mnk 3/25/2024 10:45:00'!
Nombre: aString1 dir: aString2 estCivil: aString3 fechaNac: aDate1 sueldoBasico: aFloat fechaFin: aDate2 cantHorasExtras: anInt

	^self new initializeNombre: aString1 dir: aString2 estCivil: aString3 fechaNac: aDate1 sueldoBasico: aFloat;

		initializeFechaFin: aDate2 cantHorasExtras: anInt ! !


!classDefinition: #Empresa category: #tp2_2!
Object subclass: #Empresa
	instanceVariableNames: 'nombre cuit empleados recibos calendario'
	classVariableNames: ''
	poolDictionaries: ''
	category: 'tp2_2'!

!Empresa methodsFor: 'initialization' stamp: 'mnk 4/9/2024 09:56:25'!
initializeNombre: aString cuit: anInt calendario: aCalendar

	nombre := aString.
	cuit := anInt.
	calendario := aCalendar.
	empleados := Set new.
	recibos := Set new! !


!Empresa methodsFor: 'actions' stamp: 'mnk 3/21/2024 10:18:44'!
addEmpleado: unEmpleado

	empleados add: unEmpleado! !

!Empresa methodsFor: 'actions' stamp: 'mnk 4/9/2024 10:13:08'!
liquidarSueldos

	recibos := empleados collect:[:eachEmp| ReciboHaberes Empleado: eachEmp calendario: calendario]! !


!Empresa methodsFor: 'accessing' stamp: 'mnk 3/25/2024 08:32:02'!
getRecibos

	^ recibos copy! !

!Empresa methodsFor: 'accessing' stamp: 'mnk 3/23/2024 17:03:59'!
totalRetenciones

	^ empleados sum: [:emp | emp retenciones ] ifEmpty: 0! !

!Empresa methodsFor: 'accessing' stamp: 'mnk 3/23/2024 16:52:32'!
totalSueldosBrutos

	^ empleados sum: [:emp | emp sueldoBruto ] ifEmpty: 0! !

!Empresa methodsFor: 'accessing' stamp: 'mnk 3/23/2024 15:48:18'!
totalSueldosNeto

	^ empleados sum: [:emp | emp sueldoNeto ] ifEmpty: 0! !

"-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- "!

!classDefinition: 'Empresa class' category: #tp2_2!
Empresa class
	instanceVariableNames: ''!

!Empresa class methodsFor: 'instance creation' stamp: 'mnk 4/9/2024 09:55:21'!
Nombre: aString cuit: anInt calendario: aCalendar 

	^self new initializeNombre: aString cuit: anInt calendario: aCalendar ! !


!classDefinition: #ReciboHaberes category: #tp2_2!
Object subclass: #ReciboHaberes
	instanceVariableNames: 'empleado stream fechaEmision calendario'
	classVariableNames: ''
	poolDictionaries: ''
	category: 'tp2_2'!

!ReciboHaberes methodsFor: 'initialization' stamp: 'mnk 4/9/2024 10:04:33'!
initializeEmpleado: anEmployee calendario: aCalendar

	empleado := anEmployee.
	calendario := aCalendar.
	fechaEmision := calendario getFechaDeHoy.
	stream := WriteStream on: ''.
	
	self rellenarStreamPara: anEmployee.! !


!ReciboHaberes methodsFor: 'accessing' stamp: 'mnk 3/25/2024 08:32:36'!
getEmpleado

	^ empleado! !

!ReciboHaberes methodsFor: 'accessing' stamp: 'mnk 3/24/2024 11:58:04'!
reciboContent

	^ stream contents copy! !


!ReciboHaberes methodsFor: 'private' stamp: 'mnk 3/25/2024 11:21:04'!
desgEmpCont: unEmpCont
	
	stream tab
		nextPutAll: 'Gastos administrativos contractuales: ';
		nextPutAll: unEmpCont montoGastosAdCont asString;
		newLine! !

!ReciboHaberes methodsFor: 'private' stamp: 'mnk 3/24/2024 14:11:52'!
desgEmpPer: unEmpPer
	
	stream tab
		nextPutAll: 'Asignacion por hijo: ';
		nextPutAll: unEmpPer montoAsigHijo asString;
		newLine;
		
		tab;
		nextPutAll: 'Asignacion por conyugue: ';
		nextPutAll: unEmpPer montoAsigCony asString;
		newLine;
		
		tab;
		nextPutAll: 'Por antiguedad: ';
		nextPutAll: unEmpPer montoAntig asString;
		newLine;
		
		tab;
		nextPutAll: 'Obra social: ';
		nextPutAll: unEmpPer retencionObraSocial asString;
		newLine;
		
		tab;
		nextPutAll: 'Aportes jubilatorios: ';
		nextPutAll: unEmpPer aportesJubilatorios asString;
		newLine.! !

!ReciboHaberes methodsFor: 'private' stamp: 'mnk 3/24/2024 14:11:29'!
desgEmpTem: unEmpTem

	stream tab
		nextPutAll: 'Por horas extras: ';
		nextPutAll: unEmpTem montoHorasExtras asString;
		newLine;
		
		tab;
		nextPutAll: 'Obra social: ';
		nextPutAll: unEmpTem retencionObraSocial asString;
		newLine;
		
		tab;
		nextPutAll: 'Aportes jubilatorios: ';
		nextPutAll: unEmpTem aportesJubilatorios asString;
		newLine.! !

!ReciboHaberes methodsFor: 'private' stamp: 'mnk 3/24/2024 14:15:51'!
rellenarStreamPara: unEmpleado 

	stream nextPutAll: 'Nombre del empleado: ';
		nextPutAll: unEmpleado getNombre;
		newLine;
		
		nextPutAll: 'Direccion: ';
		nextPutAll: unEmpleado getDireccion;
		newLine;
		
		nextPutAll: 'Fecha de emision: ';
		nextPutAll: fechaEmision asString;
		newLine;
		
		nextPutAll: 'Sueldo bruto: ';
		nextPutAll: unEmpleado sueldoBruto asString;
		newLine;
		
		nextPutAll: 'Sueldo neto: ';
		nextPutAll: unEmpleado sueldoNeto asString;
		newLine;
		
		nextPutAll: 'Desgloce de conceptos:';
		newLine.
		
		unEmpleado desglocePara: self.! !

"-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- "!

!classDefinition: 'ReciboHaberes class' category: #tp2_2!
ReciboHaberes class
	instanceVariableNames: ''!

!ReciboHaberes class methodsFor: 'instance creation' stamp: 'mnk 4/9/2024 09:59:57'!
Empleado: anEmployee calendario: aCalendar 

	^self new initializeEmpleado: anEmployee calendario: aCalendar! !
