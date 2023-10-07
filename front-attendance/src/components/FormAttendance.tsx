import React from "react";
import InputForm from "./InputForm";
import baseUrl from "../utils/api";
import { ICustomer, IEmployee } from "../vite-env";
import { Listbox, Transition } from "@headlessui/react";
import Camera from "react-html5-camera-photo";
import "react-html5-camera-photo/build/css/index.css";

const FormAttendance = () => {
  const [customers, setCustomers] = React.useState<ICustomer[]>([
    {
      customerId: 0,
      name: "",
      location: "",
    },
  ]);
  const [employees, setEmployees] = React.useState<IEmployee[]>([
    {
      employeeId: 0,
      id: "",
      name: "",
      photo: "",
    },
  ]);
  const [selectedEmployee, setSelectedEmployee] = React.useState<IEmployee>(
    employees[0]
  );
  const [selectedCustomer, setSelectedCustomer] = React.useState<ICustomer>(
    customers[0]
  );
  const [error, setError] = React.useState<{ error: boolean; message: string }>(
    {
      error: false,
      message: "",
    }
  );

  const [cameraPermissions, setCameraPersmissions] =
    React.useState<boolean>(false);

  React.useEffect(() => {
    const requestCameraPermission = async () => {
      try {
        const request = await navigator.mediaDevices.getUserMedia;

        setCameraPersmissions(true);
      } catch (error) {
        console.error("Error al acceder a la cámara:", error);
      }
    };
    requestCameraPermission();
  }, []);

  React.useEffect(() => {
    const requestData = async () => {
      try {
        const response = await baseUrl.get("register/api/v1/customers");
        setCustomers(response.data);
      } catch (error) {
        setError({
          error: true,
          message: "Cannot get information",
        });
      }
    };
    requestData();
  }, []);

  React.useEffect(() => {
    const requestData = async () => {
      try {
        const response = await baseUrl.get("register/api/v1/employees");
        setEmployees(response.data);
      } catch (error) {
        setError({
          error: true,
          message: "Cannot get information",
        });
      }
    };

    requestData();
  }, []);

  return (
    <form className="w-full h-96">
      <p>Customer:</p>
      <div className="top-16 w-72">
        <Listbox value={selectedCustomer} onChange={setSelectedCustomer}>
          <div className="relative mt-1">
            <Listbox.Button className="relative w-full cursor-default rounded-lg bg-white py-2 pl-3 pr-10 text-left shadow-md focus:outline-none focus-visible:border-indigo-500 focus-visible:ring-2 focus-visible:ring-white focus-visible:ring-opacity-75 focus-visible:ring-offset-2 focus-visible:ring-offset-orange-300 sm:text-sm">
              <span className="block truncate">{selectedCustomer.name}</span>
              <span className="pointer-events-none absolute inset-y-0 right-0 flex items-center pr-2">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 24 24"
                  strokeWidth={1.5}
                  stroke="currentColor"
                  className="w-5 h-5 text-gray-500"
                >
                  <path
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    d="M8.25 15L12 18.75 15.75 15m-7.5-6L12 5.25 15.75 9"
                  />
                </svg>
              </span>
            </Listbox.Button>
            <Transition
              as={React.Fragment}
              leave="transition ease-in duration-100"
              leaveFrom="opacity-100"
              leaveTo="opacity-0"
            >
              <Listbox.Options className="absolute z-50 mt-1 max-h-60 w-full overflow-auto rounded-md bg-white py-1 text-base shadow-lg ring-1 ring-black ring-opacity-5 focus:outline-none sm:text-sm">
                {customers.map((customer, personIdx) => (
                  <Listbox.Option
                    key={personIdx}
                    className={({ active }) =>
                      `relative cursor-default select-none py-2 pl-10 pr-4 ${
                        active ? "bg-indigo-500 text-white" : "text-gray-900"
                      }`
                    }
                    value={customer}
                  >
                    {({ selected }) => (
                      <>
                        <span
                          className={`block truncate ${
                            selected ? "font-medium" : "font-normal"
                          }`}
                        >
                          {customer.name}
                        </span>
                        {selected ? (
                          <span className="absolute inset-y-0 left-0 flex items-center pl-3 text-indigo-600 hover:text-white">
                            <svg
                              xmlns="http://www.w3.org/2000/svg"
                              fill="none"
                              viewBox="0 0 24 24"
                              strokeWidth={1.5}
                              stroke="currentColor"
                              className="w-6 h-6"
                            >
                              <path
                                strokeLinecap="round"
                                strokeLinejoin="round"
                                d="M4.5 12.75l6 6 9-13.5"
                              />
                            </svg>
                          </span>
                        ) : null}
                      </>
                    )}
                  </Listbox.Option>
                ))}
              </Listbox.Options>
            </Transition>
          </div>
        </Listbox>
      </div>
      <p>Employee</p>
      <div className="top-16 w-72">
        <Listbox value={selectedEmployee} onChange={setSelectedEmployee}>
          <div className="relative mt-1">
            <Listbox.Button className="relative w-full cursor-default rounded-lg bg-white py-2 pl-3 pr-10 text-left shadow-md focus:outline-none focus-visible:border-indigo-500 focus-visible:ring-2 focus-visible:ring-white focus-visible:ring-opacity-75 focus-visible:ring-offset-2 focus-visible:ring-offset-orange-300 sm:text-sm">
              <span className="block truncate">{selectedEmployee.name}</span>
              <span className="pointer-events-none absolute inset-y-0 right-0 flex items-center pr-2">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 24 24"
                  strokeWidth={1.5}
                  stroke="currentColor"
                  className="w-5 h-5 text-gray-500"
                >
                  <path
                    strokeLinecap="round"
                    strokeLinejoin="round"
                    d="M8.25 15L12 18.75 15.75 15m-7.5-6L12 5.25 15.75 9"
                  />
                </svg>
              </span>
            </Listbox.Button>
            <Transition
              as={React.Fragment}
              leave="transition ease-in duration-100"
              leaveFrom="opacity-100"
              leaveTo="opacity-0"
            >
              <Listbox.Options className="absolute z-50 mt-1 max-h-60 w-full overflow-auto rounded-md bg-white py-1 text-base shadow-lg ring-1 ring-black ring-opacity-5 focus:outline-none sm:text-sm">
                {employees.map((employee, employeeIdx) => (
                  <Listbox.Option
                    key={employeeIdx}
                    className={({ active }) =>
                      `relative cursor-default select-none py-2 pl-10 pr-4 ${
                        active ? "bg-indigo-500 text-white" : "text-gray-900"
                      }`
                    }
                    value={employee}
                  >
                    {({ selected }) => (
                      <>
                        <span
                          className={`block truncate ${
                            selected ? "font-medium" : "font-normal"
                          }`}
                        >
                          {employee.name}
                        </span>
                        {selected ? (
                          <span className="absolute inset-y-0 left-0 flex items-center pl-3 text-indigo-600 hover:text-white">
                            <svg
                              xmlns="http://www.w3.org/2000/svg"
                              fill="none"
                              viewBox="0 0 24 24"
                              strokeWidth={1.5}
                              stroke="currentColor"
                              className="w-6 h-6"
                            >
                              <path
                                strokeLinecap="round"
                                strokeLinejoin="round"
                                d="M4.5 12.75l6 6 9-13.5"
                              />
                            </svg>
                          </span>
                        ) : null}
                      </>
                    )}
                  </Listbox.Option>
                ))}
              </Listbox.Options>
            </Transition>
          </div>
        </Listbox>
      </div>

      <div className="max-w-2xl mx-auto">
        {cameraPermissions ? (
          <Camera
            isImageMirror={true}
            onTakePhoto={(dataUri: string) => {
              handleTakePhoto(dataUri);
            }}
          />
        ) : (
          <p>Camera permissions denied</p>
        )}
      </div>
    </form>
  );
};

export default FormAttendance;
