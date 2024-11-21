from faker import Faker
import random

# Inicializar Faker
fake = Faker('es_ES')

def generate_personal_data():
    genero = random.choice(['Masculino', 'Femenino'])
    return {
        'apellido_materno': fake.last_name(),
        'apellido_paterno': fake.last_name(),
        'braile': False,
        'carnet': random.randint(1000000, 9999999),
        'complemento': fake.suffix() if random.random() > 0.7 else None,
        'correo': fake.email(),
        'denominativo': fake.prefix_nonbinary(),
        'direccion_domiciliaria': fake.address(),
        'extranjero': False,
        'fecha_nacimiento': fake.date_of_birth(minimum_age=18, maximum_age=70),
        'genero': genero,
        'id_financiamiento': random.randint(1, 100),
        'id_funcion': random.randint(1, 100),
        'nombres': fake.first_name_male() if genero == 'Masculino' else fake.first_name_female(),
        'normalista': False,
        'nro_celular': fake.random_int(min=60000000, max=79999999),
        'nro_item': random.randint(1, 100),
        'rda': random.randint(1, 100)
    }

# Generar e imprimir 10 sentencias SQL de inserción
for _ in range(0):
    personal_data = generate_personal_data()

    complemento_value = f"'{personal_data['complemento']}'" if personal_data['complemento'] else 'NULL'
    
    insert_query = f"""
    INSERT INTO personal (apellido_materno, apellido_paterno, braile, carnet, complemento, correo, denominativo, 
    direccion_domiciliaria, extranjero, fecha_nacimiento, genero, id_financiamiento, id_funcion, nombres, normalista, 
    nro_celular, nro_item, rda)
    VALUES ('{personal_data['apellido_materno']}', '{personal_data['apellido_paterno']}', {personal_data['braile']}, 
    {personal_data['carnet']}, {complemento_value}, '{personal_data['correo']}', '{personal_data['denominativo']}', 
    '{personal_data['direccion_domiciliaria']}', {personal_data['extranjero']}, '{personal_data['fecha_nacimiento']}', 
    '{personal_data['genero']}', {personal_data['id_financiamiento']}, {personal_data['id_funcion']}, 
    '{personal_data['nombres']}', {personal_data['normalista']}, {personal_data['nro_celular']}, 
    {personal_data['nro_item']}, {personal_data['rda']});
    """
    
    print(insert_query)


#--------------------
def generate_colegio_data():
    # Definir valores posibles para el campo 'estado'
    estado_options = ['ACTIVO', 'INACTIVO', 'OTRO']
    
    return {
        'codigo': random.randint(1000, 9999),
        'area': random.randint(1, 10),
        'canton': random.randint(1, 100),
        'ci_director': random.randint(1000000, 9999999),
        'ciudad': random.randint(1, 100),
        'codigo_distrito': random.randint(1, 100),
        'departamento': fake.state(),
        'descripcion': fake.text(max_nb_chars=200),
        'direccion': fake.address(),
        'distrito': random.randint(1, 10),
        'estado': random.choice(estado_options),
        'id_director': random.randint(1000000, 9999999),
        'nombre': fake.company(),
        'provincia': random.randint(1, 10),
        'seccion_municipal': random.randint(1, 10),
        'turno': random.randint(1, 3),  # Por ejemplo, 1=mañana, 2=tarde, 3=noche
        'zona': random.randint(1, 10)
    }

for _ in range(3):
    colegio_data = generate_colegio_data()

    insert_query = f"""
    INSERT INTO colegio (codigo, area, canton, ci_director, ciudad, codigo_distrito, departamento, descripcion, 
    direccion, distrito, estado, id_director, nombre, provincia, seccion_municipal, turno, zona)
    VALUES ({colegio_data['codigo']}, {colegio_data['area']}, {colegio_data['canton']}, {colegio_data['ci_director']}, 
    {colegio_data['ciudad']}, {colegio_data['codigo_distrito']}, '{colegio_data['departamento']}', '{colegio_data['descripcion']}', 
    '{colegio_data['direccion']}', {colegio_data['distrito']}, '{colegio_data['estado']}', {colegio_data['id_director']}, 
    '{colegio_data['nombre']}', {colegio_data['provincia']}, {colegio_data['seccion_municipal']}, {colegio_data['turno']}, 
    {colegio_data['zona']});
    """
    
    print(insert_query)