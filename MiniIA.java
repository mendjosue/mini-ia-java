import java.util.Scanner;

public class MiniIA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=============================================");
        System.out.println("     MINI-IA STUDENT PREDICTOR");
        System.out.println("=============================================");
        System.out.println("Sistema de predicción académica");
        System.out.println("Versión 1.0");

        int continuar;
        do {
            System.out.println("\n---------------------------------------------");
            System.out.println("         REGISTRO DEL ESTUDIANTE");
            System.out.println("---------------------------------------------");

            System.out.print("Ingresa tu nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Ingresa tu edad: ");
            int edad = sc.nextInt();

            System.out.print("Horas de estudio por semana: ");
            int horasEstudio = sc.nextInt();
            while (horasEstudio < 0) {
                System.out.println("⚠️  Las horas no pueden ser negativas.");
                System.out.print("Ingresa nuevamente las horas de estudio: ");
                horasEstudio = sc.nextInt();
            }

            System.out.print("Porcentaje de asistencia (0-100): ");
            double asistencia = sc.nextDouble();
            while (asistencia < 0 || asistencia > 100) {
                System.out.println("⚠️  La asistencia debe estar entre 0 y 100.");
                System.out.print("Ingresa nuevamente la asistencia: ");
                asistencia = sc.nextDouble();
            }

            System.out.print("Nota promedio (0-100): ");
            double notaPromedio = sc.nextDouble();
            while (notaPromedio < 0 || notaPromedio > 100) {
                System.out.println("⚠️  La nota debe estar entre 0 y 100.");
                System.out.print("Ingresa nuevamente la nota: ");
                notaPromedio = sc.nextDouble();
            }

            System.out.print("Tareas completadas: ");
            int tareasCompletadas = sc.nextInt();
            while (tareasCompletadas < 0) {
                System.out.println("⚠️  No puede ser un número negativo.");
                System.out.print("Ingresa nuevamente las tareas completadas: ");
                tareasCompletadas = sc.nextInt();
            }

            System.out.print("Horas de sueño por noche: ");
            int horasSueno = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            System.out.println("\n---------------------------------------------");
            System.out.println("         ANALIZANDO DATOS");
            System.out.println("---------------------------------------------");

            // Barra de progreso
            for (int progreso = 10; progreso <= 100; progreso += 10) {
                String barra = "[" + "##".repeat(progreso / 10) + " ".repeat(10 - progreso / 10) + "] " + progreso + "%";
                System.out.println(barra);
            }
            System.out.println("✅ Análisis completado.");

            System.out.println("\n---------------------------------------------");
            System.out.println("            RESULTADO");
            System.out.println("---------------------------------------------");
            System.out.println("Estudiante:           " + nombre);
            System.out.println("Edad:                 " + edad + " años");
            System.out.println("Horas de estudio:     " + horasEstudio + " h/semana");
            System.out.println("Asistencia:           " + asistencia + "%");
            System.out.println("Nota promedio:        " + notaPromedio);
            System.out.println("Tareas completadas:   " + tareasCompletadas);
            System.out.println("Horas de sueño:       " + horasSueno + " h/noche");

            // Cálculo del Risk Score
            int riesgo = 0;
            if (horasEstudio < 5)         { riesgo += 2; }
            if (asistencia < 70)          { riesgo += 3; }
            if (notaPromedio < 60)        { riesgo += 3; }
            if (tareasCompletadas < 5)    { riesgo += 2; }
            if (horasSueno < 6)           { riesgo += 1; }

            System.out.println("\n📊 Puntaje de riesgo: " + riesgo);

            // Clasificación
            String nivelRiesgo = "";
            if (riesgo <= 2) {
                nivelRiesgo = "RIESGO BAJO";
            } else if (riesgo <= 5) {
                nivelRiesgo = "RIESGO MEDIO";
            } else {
                nivelRiesgo = "RIESGO ALTO";
            }
            System.out.println("🔮 Predicción: " + nivelRiesgo);

            // Recomendaciones
            System.out.println("\n💡 Recomendaciones:");
            if (riesgo <= 2) {
                System.out.println("✅ ¡Excelente trabajo! Sigue así.");
            } else {
                if (horasEstudio < 5)      { System.out.println("📚 Aumenta las horas de estudio."); }
                if (asistencia < 70)        { System.out.println("🏫 Mejora tu asistencia a clases."); }
                if (notaPromedio < 60)      { System.out.println("📝 Necesitas mejorar tus calificaciones."); }
                if (tareasCompletadas < 5)  { System.out.println("✅ Completa todas tus tareas."); }
                if (horasSueno < 6)         { System.out.println("😴 Duerme al menos 6 horas."); }
            }

            System.out.println("\n=============================================");
            System.out.println("\n¿Quieres analizar otro estudiante?");
            System.out.println("1. Sí");
            System.out.println("2. No");
            System.out.print("Elige una opción: ");
            continuar = sc.nextInt();
            sc.nextLine();

        } while (continuar == 1);

        System.out.println("\n👋 ¡Programa finalizado!");
        sc.close();
    }
}