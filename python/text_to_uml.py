
import xml.etree.ElementTree as ET
import copy
import argparse
import re

# Embedded template GraphML content (with labels)
TEMPLATE_GRAPHML = r"""<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<graphml xmlns="http://graphml.graphdrawing.org/xmlns" xmlns:java="http://www.yworks.com/xml/yfiles-common/1.0/java" xmlns:sys="http://www.yworks.com/xml/yfiles-common/markup/primitives/2.0" xmlns:x="http://www.yworks.com/xml/yfiles-common/markup/2.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:y="http://www.yworks.com/xml/graphml" xmlns:yed="http://www.yworks.com/xml/yed/3" xsi:schemaLocation="http://graphml.graphdrawing.org/xmlns http://www.yworks.com/xml/schema/graphml/1.1/ygraphml.xsd">
  <!--Created by yEd 3.25.1-->
  <key for="port" id="d0" yfiles.type="portgraphics"/>
  <key for="port" id="d1" yfiles.type="portgeometry"/>
  <key for="port" id="d2" yfiles.type="portuserdata"/>
  <key attr.name="url" attr.type="string" for="node" id="d3"/>
  <key attr.name="description" attr.type="string" for="node" id="d4"/>
  <key for="node" id="d5" yfiles.type="nodegraphics"/>
  <key for="graphml" id="d6" yfiles.type="resources"/>
  <key attr.name="url" attr.type="string" for="edge" id="d7"/>
  <key attr.name="description" attr.type="string" for="edge" id="d8"/>
  <key for="edge" id="d9" yfiles.type="edgegraphics"/>
  <graph edgedefault="directed" id="G">
    <node id="n0">
      <data key="d5">
        <y:UMLClassNode>
          <y:Geometry height="373.79693005217285" width="416.1640625" x="-212.76555684315184" y="-694.5595788248392"/>
          <y:Fill color="#CCE5FF" transparent="false"/>
          <y:BorderStyle color="#000000" type="line" width="1.0"/>
          <y:NodeLabel alignment="center" autoSizePolicy="content" fontFamily="Dialog" fontSize="12" fontStyle="bold" hasBackgroundColor="false" hasLineColor="false" height="17.96875" horizontalTextPosition="center" iconTextGap="4" modelName="internal" modelPosition="b" textColor="#000000" verticalTextPosition="bottom" visible="true" width="96.279296875" x="159.9423828125" xml:space="preserve" y="25.96875">1. Restaurant</y:NodeLabel>
          <y:UML clipContent="true" constraint="{manages operations}" hasDetailsColor="false" omitDetails="false" stereotype="«inherits SimEntity»" use3DEffect="true">
            <y:AttributeLabel xml:space="preserve">- name: String
- tables: List&lt;Table&gt;
- menu: List&lt;Platter&gt;
- staff: List&lt;Staff&gt;
- revenue: double
- avgWalkTime: double
- globals: GlobalVariables
- decisionEngine: GlobalMethods</y:AttributeLabel>
            <y:MethodLabel xml:space="preserve">+ simulateDay()
+ decideStaffing()
+ decideTableAssignments()
+ decideInventoryRestock()
+ decideStaffing (uses Probability:
+ RushHourOverloadChance)
decideInventoryRestock (uses Probability: IngredientSpoilageRate)
+ getGlobals(): GlobalVariables
+ getDecisionEngine(): GlobalMethods
+ evaluate(): boolean
+ commit(): void
+ getState(): String[][]</y:MethodLabel>
          </y:UML>
        </y:UMLClassNode>
      </data>
    </node>
    <node id="n1">
      <data key="d3" xml:space="preserve"/>
      <data key="d5">
        <y:UMLClassNode>
          <y:Geometry height="298.67414540021343" width="526.54296875" x="-258.04963705378276" y="-73.77267479805494"/>
          <y:Fill color="#FFD9B3" transparent="false"/>
          <y:BorderStyle color="#000000" type="line" width="1.0"/>
          <y:NodeLabel alignment="center" autoSizePolicy="content" fontFamily="Dialog" fontSize="12" fontStyle="bold" hasBackgroundColor="false" hasLineColor="false" height="17.96875" horizontalTextPosition="center" iconTextGap="4" modelName="internal" modelPosition="br" textColor="#000000" verticalTextPosition="bottom" visible="true" width="161.412109375" x="182.5654296875" xml:space="preserve" y="25.96875">19. SimulationManager</y:NodeLabel>
          <y:UML clipContent="true" constraint="{drives simulation clk}" hasDetailsColor="false" omitDetails="false" stereotype="«Simulation Kernel with Console &amp; Waveform»" use3DEffect="true">
            <y:AttributeLabel xml:space="preserve"># processes: List&lt;SimProcess&gt;</y:AttributeLabel>
            <y:MethodLabel xml:space="preserve">+ registerProcess(SimProcess)
+ run(int): void
+ stepOnce(): void
+ getClock(): SimulationClock
+ getProcesses(): List&lt;SimProcess&gt;
+ startConsole(): void
+ listObjects(): void
+ showObject(String): void
+ setValue(String, String, String): void
+ startLogging(String): void
+ stopLogging(): void
+ logTick(int): void
+ displayStates(): void</y:MethodLabel>
          </y:UML>
        </y:UMLClassNode>
      </data>
    </node>
    <edge id="e0" source="n1" target="n0">
      <data key="d9">
        <y:PolyLineEdge>
          <y:Path sx="0.0" sy="0.0" tx="0.0" ty="0.0"/>
          <y:LineStyle color="#000000" type="line" width="1.0"/>
          <y:Arrows source="none" target="standard"/>
          <y:EdgeLabel alignment="center" configuration="AutoFlippingLabel" distance="2.0" fontFamily="Dialog" fontSize="12" fontStyle="plain" hasBackgroundColor="false" height="17.96875" horizontalTextPosition="center" iconTextGap="4" lineColor="#000000" modelName="custom" preferredPlacement="center_on_edge" ratio="0.5" textColor="#000000" verticalTextPosition="bottom" visible="true" width="31.234375" x="-3.1413749474109127" xml:space="preserve" y="-142.28011870619423">19-1<y:LabelModel><y:SmartEdgeLabelModel autoRotationEnabled="false" defaultAngle="0.0" defaultDistance="10.0"/></y:LabelModel><y:ModelParameter><y:SmartEdgeLabelModelParameter angle="6.283185307179586" distance="14.737552520045023" distanceToCenter="true" position="right" ratio="0.5447179839238978" segment="-1"/></y:ModelParameter><y:PreferredPlacementDescriptor angle="0.0" angleOffsetOnRightSide="0" angleReference="absolute" angleRotationOnRightSide="co" distance="-1.0" placement="center" side="on_edge" sideReference="relative_to_edge_flow"/></y:EdgeLabel>
          <y:BendStyle smoothed="false"/>
        </y:PolyLineEdge>
      </data>
    </edge>
    <edge id="e1" source="n0" target="n1">
      <data key="d9">
        <y:PolyLineEdge>
          <y:Path sx="0.0" sy="0.0" tx="0.0" ty="0.0"/>
          <y:LineStyle color="#000000" type="line" width="1.0"/>
          <y:Arrows source="none" target="standard"/>
          <y:BendStyle smoothed="false"/>
        </y:PolyLineEdge>
      </data>
    </edge>
  </graph>
  <data key="d6">
    <y:Resources/>
  </data>
</graphml>
"""

# Namespaces
NS = {
    'graphml': "http://graphml.graphdrawing.org/xmlns",
    'y': "http://www.yworks.com/xml/graphml"
}
ET.register_namespace('', NS['graphml'])
ET.register_namespace('y', NS['y'])

COLOR_MAP = {
    "«Utility»": "#E0E0E0",
    "«inherits SimEntity»": "#CCE5FF",
    "«Simulation Kernel with Console & Waveform»": "#FFD966"
}

def parse_text_file(file_path):
    objects, connections = [], []
    current = {}
    with open(file_path, 'r') as f:
        for line in f:
            line = line.strip()
            if not line:
                if "name" in current:
                    objects.append(current)
                current = {}
                continue
            if line.startswith("object:"):
                current = {"attributes": [], "methods": []}
                current["name"] = line.split(":", 1)[1].strip().strip('"')
            elif line.startswith("stereotype:"):
                current["stereotype"] = line.split(":", 1)[1].strip().strip('"')
            elif line.startswith("constraint:"):
                current["constraint"] = line.split(":", 1)[1].strip().strip('"')
            elif line.startswith("attribute:"):
                current["attributes"].append(line.split(":", 1)[1].strip().strip('"'))
            elif line.startswith("method:"):
                method_line = line.split(":", 1)[1].strip().strip('"')
                if current["methods"] and current["methods"][-1].endswith("(uses Probability:"):
                    current["methods"][-1] += f" {method_line}"
                else:
                    current["methods"].append(method_line)
            elif line.startswith("connection:"):
                parts = line.split('"')
                connections.append({"source": parts[1], "target": parts[3]})
            elif line.startswith("label:"):
                if connections:
                    connections[-1]["label"] = line.split(":", 1)[1].strip().strip('"')
        if "name" in current:
            objects.append(current)
    return objects, connections

def generate_graphml(text_file, output_file, override_color=None):
    tree = ET.ElementTree(ET.fromstring(TEMPLATE_GRAPHML))
    root = tree.getroot()
    graph = root.find(".//graphml:graph", NS)

    template_node = graph.find(".//graphml:node", NS)
    template_edge = graph.find(".//graphml:edge", NS)

    for elem in list(graph):
        if elem.tag.endswith('node') or elem.tag.endswith('edge'):
            graph.remove(elem)

    objects, connections = parse_text_file(text_file)
    name_to_id = {}

    for i, obj in enumerate(objects):
        node_id = f"n{i}"
        name_to_id[obj["name"]] = node_id
        new_node = copy.deepcopy(template_node)
        new_node.set("id", node_id)

        node_label = new_node.find(".//y:NodeLabel", NS)
        if node_label is not None:
            node_label.text = obj["name"]

        uml = new_node.find(".//y:UML", NS)
        if uml is not None:
            uml.set("stereotype", obj.get("stereotype", ""))
            uml.set("constraint", obj.get("constraint", ""))
            attr_label = uml.find("y:AttributeLabel", NS)
            meth_label = uml.find("y:MethodLabel", NS)
            if attr_label is not None:
                attr_label.text = "\n".join(obj["attributes"])
            if meth_label is not None:
                meth_label.text = "\n".join(obj["methods"])

        fill_elem = new_node.find(".//y:Fill", NS)
        if fill_elem is not None:
            if override_color:
                fill_elem.set("color", override_color)
            else:
                stereotype = obj.get("stereotype", "")
                fill_elem.set("color", COLOR_MAP.get(stereotype, "#CCE5FF"))
            fill_elem.set("transparent", "false")

        graph.append(new_node)

    for i, conn in enumerate(connections):
        source_id = name_to_id.get(conn["source"])
        target_id = name_to_id.get(conn["target"])
        if not source_id or not target_id:
            continue
        new_edge = copy.deepcopy(template_edge)
        new_edge.set("id", f"e{i}")
        new_edge.set("source", source_id)
        new_edge.set("target", target_id)

        edge_label = new_edge.find(".//y:EdgeLabel", NS)
        if edge_label is not None:
            if "label" in conn and conn["label"]:
                edge_label.text = conn["label"]
            else:
                src_idx = re.findall(r'\d+', conn["source"])
                tgt_idx = re.findall(r'\d+', conn["target"])
                if src_idx and tgt_idx:
                    edge_label.text = f"{src_idx[0]}-{tgt_idx[0]}"
                else:
                    edge_label.text = f"{conn['source']}→{conn['target']}"

        graph.append(new_edge)

    tree.write(output_file, encoding="utf-8", xml_declaration=True)
    print(f"✅ GraphML with colors and labels generated: {output_file}")

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="Generate UML GraphML with embedded labeled template.")
    parser.add_argument("-i", "--input", required=True, help="Input text file with UML objects.")
    parser.add_argument("-o", "--output", required=True, help="Output GraphML file.")
    parser.add_argument("--color", help="Override color for all nodes (hex, e.g., #FFDD00).")
    args = parser.parse_args()

    generate_graphml(args.input, args.output, override_color=args.color)
