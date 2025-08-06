# Java Simulation Kernel Framework

This project provides a **reusable, general-purpose simulation framework** in Java, inspired by HDL simulators like Verilog/SystemC. 
It features a heartbeat-driven simulation loop, an integrated console for interactive debugging, GTKWave waveform logging, and single-step tick control.

---

## ✨ Features
- **Simulation Kernel (HeartbeatManager)**: Central engine managing evaluate/commit cycles for all entities.
- **Interactive Console**:
  - Inspect object state (`show` command).
  - Modify values at runtime (`set` command).
  - Single-step or run ticks (`tick` and `run` commands).
- **Waveform Logging (GTKWave Integration)**:
  - Export simulation state to `.vcd` files.
  - Visualize signals and object states over time in GTKWave.
- **Inheritance Model**:
  - `SimEntity` base class with built-in tick logic.
  - All simulation objects inherit from `SimEntity` for consistency.
- **Single-Step Debugging**:
  - Advance simulation one tick at a time for fine-grained analysis.
- **Modular and Reusable**:
  - Extendable to model restaurants, traffic systems, CPUs, robotics, or any discrete-time system.

---

## 📂 Project Structure
```
.
├── src/                            # Java source files
│   ├── SimProcess.java
│   ├── SimEntity.java
│   ├── SimulationClock.java
│   ├── HeartbeatManager.java
│   ├── Main.java
│   ├── Entities/
│   │   ├── Restaurant.java
│   │   ├── Cook.java
│   │   ├── Customer.java
│   │   ├── Server.java
│   │   ├── Table.java
│   │   └── ... (other entities)
│
├── doc/
│   ├── Object_and_Method_Reference.docx       # UML object/method reference
│   ├── SimulationKernel_QuickStartGuide.pdf   # Quick start guide for the simulation kernel
│   ├── UML_template.graphml                   # Original UML template for yEd
│   ├── yEd_UML.graphml                        # Example UML GraphML output
│
├── python/
│   ├── text_to_uml.py                         # UML generator script (embedded template)
```

---

## 🚀 Getting Started

### Prerequisites
- **Java JDK 11+**
- **GTKWave** (for waveform viewing): [https://gtkwave.sourceforge.net/](https://gtkwave.sourceforge.net/)

### Build & Run
1. Compile all Java files:
   ```bash
   make
   ```
2. Run the simulation kernel:
   ```bash
   make run
   ```
3. You'll see the simulation prompt:
   ```
   sim>
   ```

---

## 🖥 Console Commands
- `help` → Show all commands.
- `list` → List all registered simulation objects.
- `show <object>` → Display the state of an object.
- `set <object> <field> <value>` → Modify an object's field at runtime.
- `tick [N]` → Advance simulation by N ticks (default: 1).
- `run <N>` → Run simulation for N ticks continuously.
- `log start <filename>` → Start waveform logging to `<filename>.vcd`.
- `log stop` → Stop waveform logging.
- `quit` → Exit the simulation console.

---

## 📊 Waveform Logging (GTKWave Integration)
1. Start waveform logging from the console:
   ```
   sim> log start simulation.vcd
   sim> run 100
   sim> log stop
   ```
2. Open the generated VCD file in GTKWave:
   ```bash
   gtkwave simulation.vcd
   ```
3. Analyze tick-by-tick state changes for all objects.

---

## 🔧 Extending the Framework
- Add new simulation objects by extending `SimEntity` and overriding `getState()`.
- Register them with the kernel using `hb.registerProcess(...)`.
- Console and waveform logging automatically include all registered entities.

---

## 🛠 Future Enhancements
- **Breakpoints & Watchpoints** (e.g., stop when a variable changes).
- **Event-driven scheduling** for asynchronous events.
- **State save/load** for checkpointing and rollback.
- **Conditional triggers** (e.g., auto-log or pause on specific conditions).

---

## 📘 UML GraphML Generator (Python)

A Python-based tool to generate UML diagrams in GraphML format for yEd.

### 🔧 Dependencies
- Python 3.8+
- No external libraries (standard library only).

### ▶️ Usage
Run the generator script from the `python` folder:
```bash
cd system-sim/restaurant-simulation/python

python3 text_to_uml.py -i ../doc/UML_objects_connections_19_with_colors.txt -o ../doc/yEd_UML.graphml
```

### Options:
- `-i` or `--input`: Text file containing UML objects and connections.
- `-o` or `--output`: Output `.graphml` file.
- `--color`: (Optional) Override color for all nodes (hex, e.g. `#FFDD00`).

### 📝 Input File Format
```
object: "Object1"
stereotype: "«Utility»"
attribute: "id: int"
method: "run()"

object: "Object2"
stereotype: "«inherits SimEntity»"
attribute: "name: str"
method: "start()"

connection: "Object1" -> "Object2"
connection: "Object2" -> "Object3"
```

- Each object block is separated by a blank line.
- `connection:` statements are listed separately after objects.
- Connection labels are auto-generated (e.g., `1-2`, `2-3`).

---

## 📄 License
GPLv3 License.

---

## 👤 Author
- Edward Diaz  
  GitHub: [ead0601](https://github.com/ead0601)
