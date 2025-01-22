import heapq
import os


# Read the graph from a file
def read_graph_from_file(filename):
    graph = {}
    with open(filename, 'r') as file:
        lines = file.readlines()
        num_flights = int(lines[0].strip())
        for line in lines[1:num_flights + 1]:
            source, destination, cost = line.strip().split('|')
            cost = float(cost)

            if source not in graph:
                graph[source] = {}
            graph[source][destination] = cost

            # Assuming bidirectional flights
            if destination not in graph:
                graph[destination] = {}
            graph[destination][source] = cost

    return graph


# Read requested flights from a file
def read_requested_flights(filename):
    with open(filename, 'r') as file:
        return [line.strip().split('|') for line in file.readlines()]


# Dijkstra's algorithm
def dijkstra(graph, start):
    distances = {node: float('inf') for node in graph}
    distances[start] = 0
    paths = {node: [start] if node == start else [] for node in graph}
    priority_queue = [(0, start)]

    while priority_queue:
        current_distance, current_node = heapq.heappop(priority_queue)
        if current_distance > distances[current_node]:
            continue

        for neighbor, weight in graph[current_node].items():
            distance = current_distance + weight
            if distance < distances[neighbor]:
                distances[neighbor] = distance
                heapq.heappush(priority_queue, (distance, neighbor))
                paths[neighbor] = paths[current_node] + [neighbor]

    return distances, paths


# Backtracking algorithm to find all paths
def backtracking(graph, start, end):
    stack = [(start, [start], 0)]
    all_paths = []

    while stack:
        current_node, path, cost = stack.pop()
        if current_node == end:
            all_paths.append((path[:], cost))
            continue

        for neighbor, weight in graph[current_node].items():
            if neighbor not in path:
                stack.append((neighbor, path + [neighbor], cost + weight))

    return all_paths


# Write results to output.txt
def write_output(filename, requests, graph, results):
    with open(filename, 'w') as file:
        for request, (dijkstra_result, backtracking_result) in zip(requests, results):
            source, destination = request
            distances, paths = dijkstra_result

            # Write Dijkstra's result
            file.write(f"Shortest path from {source} to {destination}:\n")
            if distances[destination] < float('inf'):
                path_str = " -> ".join(paths[destination])
                file.write(f"Path: {path_str}, Distance: {distances[destination]}\n")
            else:
                file.write(f"No path from {source} to {destination}.\n")

            # Write backtracking result
            file.write(f"\nAll paths from {source} to {destination}:\n")
            if backtracking_result:
                for path, cost in backtracking_result:
                    path_str = " -> ".join(path)
                    file.write(f"Path: {path_str}, Cost: {cost}\n")
            else:
                file.write("No paths found.\n")

            file.write("\n")


# Main function
def main():
    # Input files
    flight_data_file = "flight_data.txt"
    requested_flights_file = "requested_flights.txt"
    output_file = "output.txt"

    # Check if input files exist
    if not os.path.exists(flight_data_file):
        print(f"Error: {flight_data_file} not found.")
        return
    if not os.path.exists(requested_flights_file):
        print(f"Error: {requested_flights_file} not found.")
        return

    # Read graph and requested flights
    graph = read_graph_from_file(flight_data_file)
    requested_flights = read_requested_flights(requested_flights_file)

    # Process each requested flight
    results = []
    for source, destination in requested_flights:
        # Dijkstra's algorithm for shortest path
        distances, paths = dijkstra(graph, source)

        # Backtracking for all paths
        all_paths = backtracking(graph, source, destination)

        # Store results
        results.append(((distances, paths), all_paths))

    # Write results to output.txt
    write_output(output_file, requested_flights, graph, results)
    print(f"Results written to {output_file}")


if __name__ == "__main__":
    main()
