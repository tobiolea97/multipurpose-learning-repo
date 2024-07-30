### Basic commands
- `npm install -g @nestjs/cli` - Install the Nest CLI globally
- `npm run start:dev` - Start the application in development mode

### Components creation
- `nest new project-name` - Create a new Nest project
- `nest generate module module-name` - Generate a new module
- `nest generate controller controller-name` - Generate a new controller
- `nest generate service service-name` - Generate a new service
- `nest generate class class-name` - Generate a new class

### Nest CLI
- `nest --version` - Display the current Nest version
- `nest --help` - Display the list of available commands
- `nest --help <command>` - Display the help for a specific command


### Info

- Usamos CORS para permitir que el front end se comunique con el backend. Es importante configurar el "allow-origins"
- Usamos rate limit para impedir ataques de fuerza bruta
- Usamos Prisma como ORM
- Usamos Neon como base de datos Postgres
- Si bien nuestros servicios son async, quien consume un metodo await es prisma