# Change Log
All notable changes to this project will be documented in this file.

## FORMAT:
## [version sdk] - dd.mm.yyyy

### Added

### Changed

### Fixed

---

## [3.6.4] - 20.10.2025

### Changed

- fixed 16kb issue

## [3.5.3] - 08.01.2025

### Changed

- updated dependencies
- updated Google Pay Button API
- added support for Android 15

## [3.5.2] - 04.12.2024

### Added

- params `googlePlayEnabled` and `cardFormEnabled` to `AmountType.ConstantAmount` and `AmountType.FreeAmount`

## [3.5.0] - 05.08.2024

### Added

- Lookup method

## [3.4.8] - 05.03.2024

### Fixed

- Crash in release mode

## [3.4.7] - 23.02.2024

### Added

- `Payment3DsByPassType` in `AdditionalData`
- `unit` in `Product`
- `taxes` in `Product`

### Changed

- `product.qty` from `Long` to `Double`

### Fixed

- `browserTimeZoneOffset`


## [3.3.4] - 12.12.2023

### Fixed

- Update GPay button

## [3.2.3-rc1] - 11.08.2023

### Added

- Add logger in init library
- Add new field in `PaymentModel`

#### Changed

- Change `PaymentStatus` class

## [3.0.1] - 11.08.2023

### Fixed

- Fix redirect url
