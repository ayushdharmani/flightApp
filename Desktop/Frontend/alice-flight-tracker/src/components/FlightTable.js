// components/FlightTable.js
import React from 'react';
import styled from 'styled-components';

const TableContainer = styled.div`
  background-color: rgba(255, 255, 255, 0.9);
  border-radius: 10px;
  padding: 1rem;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  width: 100%;
  max-width: 1200px;
  overflow-x: auto;
`;

const Table = styled.table`
  width: 100%;
  border-collapse: separate;
  border-spacing: 0;
`;

const TableHeader = styled.th`
  background-color: #003366;
  color: white;
  padding: 1rem;
  text-align: left;
`;

const TableRow = styled.tr`
  &:nth-child(even) {
    background-color: #f8f8f8;
  }
`;

const TableCell = styled.td`
  padding: 1rem;
  border-bottom: 1px solid #e0e0e0;
`;

const StatusCell = styled(TableCell)`
  font-weight: bold;
  color: ${props => {
    switch (props.status) {
      case 'On Time': return '#4CAF50';
      case 'Delayed': return '#FFC107';
      case 'Cancelled': return '#F44336';
      default: return '#03346E';
    }
  }};
`;

function FlightTable({ flights }) {
  console.log('Flights data received:', flights); // Add this line for debugging

  if (!flights) {
    return <p>No flight data available.</p>;
  }

  if (!Array.isArray(flights)) {
    console.error('Flights data is not an array:', flights);
    return <p>Error: Flight data is in an unexpected format.</p>;
  }

  if (flights.length === 0) {
    return <p>No flights currently scheduled.</p>;
  }

  return (
    <TableContainer>
      <Table>
        <thead>
          <tr>
            <TableHeader>Flight No.</TableHeader>
            <TableHeader>Airline</TableHeader>
            <TableHeader>Status</TableHeader>
            <TableHeader>Departure Gate</TableHeader>
            <TableHeader>Arrival Gate</TableHeader>
            <TableHeader>Scheduled Departure</TableHeader>
            <TableHeader>Scheduled Arrival</TableHeader>
          </tr>
        </thead>
        <tbody>
          {flights.map(flight => (
            <TableRow key={flight.id}>
              <TableCell>{flight.flight_id}</TableCell>
              <TableCell>{flight.airline}</TableCell>
              <StatusCell status={flight.status}>{flight.status}</StatusCell>
              <TableCell>{flight.departure_gate}</TableCell>
              <TableCell>{flight.arrival_gate}</TableCell>
              <TableCell>{new Date(flight.scheduled_departure).toLocaleString()}</TableCell>
              <TableCell>{new Date(flight.scheduled_arrival).toLocaleString()}</TableCell>
            </TableRow>
          ))}
        </tbody>
      </Table>
    </TableContainer>
  );
}

export default FlightTable;